(ns leiningen.flyway
  "Let leiningen to execute task"
  (:require [leiningen.core.main :refer [info]]
            [leiningen.core.eval :refer [eval-in-project]]))

(def ^:private CURRENT_VERSION "1.0.0")

(defn flyway
  "To execute flyway task."
  {:help-arglists '([clean baseline migrate info validate])}
  [project task]

  (info "Execute task:" task)

  (let [config (:flyway project)]
    (info config)
    (eval-in-project
     (update-in project [:dependencies] conj ['al.rug/lein-flyway CURRENT_VERSION])

     `(let [f# (fw/make-flyway ~config)
            task-map# {:clean fw/clean :info fw/info :migrate fw/migrate :validate fw/validate :baseline fw/baseline}
            t# (task-map# (keyword ~task))]
        (t# f#))

     '(require '[al.rug.flyway :as fw])))

  (info "Finish task:" task))
