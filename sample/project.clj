(defproject clojure-template "1.0.0-SNAPSHOT"
  :description "A generic template for clojure"
  :url "http://example.com/FIXME"
  :min-lein-version "2.0.0"
  :mirrors {#"clojars"
            {:name "Clojar Mirror"
             :url "https://mirrors.tuna.tsinghua.edu.cn/clojars"
             :repo-manager true}
            #"central"
            {:name "Maven aliyun"
             :url "https://maven.aliyun.com/repository/public"
             :repo-manager true}}
  :dependencies [[org.clojure/clojure "1.11.1"]
                 ;ring
                 ;database
                 [com.h2database/h2 "2.2.224"]
                 ;ORM
                 ;nrepl
                 [nrepl/lein-nrepl "0.3.2"]
                 ;graphql
                 [integrant "0.8.0"]
                 [environ "1.2.0"]]
  :plugins [[lein-bikeshed "0.5.2"]
            [lein-environ "1.2.0"]
            [lein-pprint "1.3.2"]
            [lein-cloverage "1.2.2"]
            [com.jakemccrary/lein-test-refresh "0.25.0"]]
  :main ^:skip-aot ga.rugal.clojure.main
  :ring {:handler       ga.rugal.clojure.main/-main
         :auto-reload?  true
         :auto-refresh? true}
  :test-refresh {:quiet true}
  :flyway {:flyway-configuration-path "resources/database/flyway.edn"}
  :bikeshed {:var-redefs           false
             :trailing-blank-lines false
             :max-line-length      100
             :name-collisions      false}
  :cloverage {:junit?         true
              :fail-threshold 90}
  :profiles {})
