(defproject ga.rugal/lein-flyway "0.0.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :license {:name "EPL-2.0 OR GPL-2.0-or-later WITH Classpath-exception-2.0"
            :url "https://www.eclipse.org/legal/epl-2.0/"}
  :mirrors {#"clojars"
            {:name "Clojar Mirror"
             :url "https://mirrors.tuna.tsinghua.edu.cn/clojars"
             :repo-manager true}
            #"central"
            {:name "Maven aliyun"
             :url "https://maven.aliyun.com/repository/public"
             :repo-manager true}}

  :eval-in-leiningen true

  :dependencies [[org.flywaydb/flyway-core "9.22.3"]]

  :plugins      [[com.jakemccrary/lein-test-refresh "0.25.0"]
                 [lein-bikeshed "0.5.2"]]

  :profiles {:dev {:dependencies [[org.clojure/clojure "1.11.1"]
                                  [com.h2database/h2 "2.2.224"]]}
             :uberjar     {:aot :all}
             :production  {}
             }

  :test-refresh {:changes-only true
                 :quiet true}

  :bikeshed {:var-redefs           false
             :trailing-blank-lines false
             :max-line-length      100
             :name-collisions      false})
