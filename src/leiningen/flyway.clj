(ns leiningen.flyway
  "Let leiningen to execute task"
  (:require [leiningen.core.main :refer [info]]
            [leiningen.core.eval :refer [eval-in-project]]
            [ga.rugal.flyway :as fw]))

(def ^{:private true} task-map
  "Map task keyword to actual function object"
  {:clean fw/clean
   :info  fw/info
   :migrate fw/migrate
   :validate fw/validate
   :baseline fw/baseline
   })

(defn flyway
  "To execute flyway task."
  {:help-arglists '([clean baseline migrate info validate])}
  [project task]

  (info "Execute task: " task)
  (eval-in-project
    project
    `(let [f (fw/make-flyway (:flyway project))] ((task-map (keyword task)) f))
    '(require '[ga.rugal.flyway :as fw])
    )
  (info "Finish task: " task))
