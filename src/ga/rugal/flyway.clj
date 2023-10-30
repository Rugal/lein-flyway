(ns ga.rugal.flyway
  "Contains primary logic to convert and execute flyway task"
  (:require [clojure.edn :as edn]
            [clojure.java.io :as io]
            [clojure.string :as str]
            )
  (:import
    ; [java.io File PushbackReader StringReader]
    [java.util Properties]
    [org.flywaydb.core Flyway]
    [org.flywaydb.core.api.configuration FluentConfiguration]
    ; [org.flywaydb.core.internal.util FileUtils]
    [org.flywaydb.core.internal.info MigrationInfoDumper]
    )
  )

(defn ^{:private true} make-flyway-prop
  "Given a keyword, create a property for flyway to use in a `java.util.Properties` object."
  [k]
  (let [fkey (str/split (name k) #"[-_]")]
    (str/join "" (cons "flyway."
                       (cons (first fkey)
                             (map str/capitalize (rest fkey)))))))

(defn map-2-property
  "Convert clojure map to java Properties"
  ^Properties [config]
  (doto (Properties.)
    (#(doseq [[k v] config]
        (when v
          (cond
            (vector? v) (.setProperty ^Properties % (make-flyway-prop k) (str/join "," v))
            (map? v)  (doseq [[k2 v2] v]
                        (.setProperty ^Properties %
                                      (str (make-flyway-prop k) "." (name k2))
                                      (str v2)))
            :else     (.setProperty ^Properties % (make-flyway-prop k) (str v))))))))

(defn make-flyway
  "Create Flyway configuration object"
  ^Flyway [config]

  (-> (FluentConfiguration.)
      (.configuration (map-2-property config))
      (.load)))

(defn clean
  "Execute Flyway clean"
  [^Flyway fw]
  (. fw clean))

(defn info
  "Execute Flyway info"
  [^Flyway fw]
  (println (MigrationInfoDumper/dumpToAsciiTable (.. fw info all))))

(defn migrate
  "Execute Flyway migrate"
  [^Flyway fw]
  (. fw migrate))

(defn baseline
  "Execute Flyway baseline"
  [^Flyway fw]
  (. fw baseline))

(defn validate
  "Validate flyway migration status"
  [^Flyway fw]
  (. fw validate))
