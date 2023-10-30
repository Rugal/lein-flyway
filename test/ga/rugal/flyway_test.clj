(ns ga.rugal.flyway-test
  (:require [clojure.test :as t :refer [deftest is]]
            [ga.rugal.flyway :as f])
  (:import 
    java.util.Properties
    [org.flywaydb.core Flyway]
    [org.flywaydb.core.internal.info MigrationInfoDumper]))

(def config {:user                      "root"
             :password                  "password"
             :url                       "jdbc:h2:mem:h2db"
             :cleanDisabled             "false"
             :locations                 ["filesystem:./resources/database/"]})

(def ^Properties properties (f/map-2-property config))

(deftest map-2-property
  (is (instance? Properties properties))
  (is (= 5 (count properties)))
  (is (= (:user config) (.getProperty properties "flyway.user")))
  )

(deftest make-flyway
  (let [fw (f/make-flyway config)]
    (is (instance? Flyway fw))
    (println (MigrationInfoDumper/dumpToAsciiTable (.. fw info all)))
    )
  )

(deftest flyway-task
  (let [fw (f/make-flyway config)]
    (f/info fw)
    (f/clean fw)
    (f/migrate fw)
    )
  )
