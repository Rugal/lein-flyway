(ns al.rug.flyway-test
  (:require [clojure.test :as t :refer [deftest is testing]]
            [al.rug.flyway :as f])
  (:import
    java.util.Properties
    [org.flywaydb.core Flyway]
    [org.flywaydb.core.internal.info MigrationInfoDumper]))

(def config {:user                      "root"
             :password                  "password"
             :url                       "jdbc:h2:mem:h2db"
             :cleanDisabled             "false"
             :locations                 ["filesystem:./src/test/resources/database/"]})

(def project-config {:flyway-configuration-path "src/test/resources/database/flyway.edn"})

(def ^Properties properties (f/map-2-property config))

(deftest map-2-property
  (testing "map-2-property verification"
    [(is (instance? Properties properties))
     (is (= 5 (count properties)))
     (is (= (:user config) (.getProperty properties "flyway.user")))]))

(deftest make-flyway
  (testing "flyway object creation"
    [(let [fw (f/make-flyway project-config)]
       (println (MigrationInfoDumper/dumpToAsciiTable (.. fw info all)))
       (is (instance? Flyway fw)))]))

(deftest flyway-task
  (testing "Iterate each task"
    [(let [fw (f/make-flyway project-config)]
       (f/clean fw)
       (f/info fw)
       (f/migrate fw)
       ; (f/validate fw)
       (f/baseline fw))]))

(deftest read-configuration
  (testing "Read EDN configuration"
    [(let [p (f/read-configuration "src/test/resources/database/flyway.edn")]
       (is (instance? Properties properties))
       (is (= 5 (count properties)))
       (is (= (:user config) (.getProperty p "flyway.user"))))]))
