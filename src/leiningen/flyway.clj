(ns leiningen.flyway
  (:require [leiningen.core.main :refer [info]]
            [ga.rugal.flyway :as fw]))

(def ^{:private true} task-map 
  {:clean fw/clean
   :info  fw/info
   })

(defn flyway
  "To execute flyway task."
  {:help-arglists '([clean baseline migrate info validate repair])}
  [project task]

  (info "Execute task: " task)
  ((task-map (keyword task)) project)
  )
