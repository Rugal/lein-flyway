(defproject al.rug/lein-flyway "0.0.0-SNAPSHOT"
  :description "Flyway leiningen plugin that is upgraded to match flyway-core 9.22.x version"
  :url "https://github.com/Rugal/lein-flyway"
  :license {:name "EPL-2.0"
            :url "https://www.eclipse.org/legal/epl-2.0/"}
  :mirrors {#"clojars"
            {:name "Clojar Mirror"
             :url "https://mirrors.tuna.tsinghua.edu.cn/clojars"
             :repo-manager true}
            #"central"
            {:name "Maven aliyun"
             :url "https://maven.aliyun.com/repository/public"
             :repo-manager true}}

  :scm {:url "git@github.com:Rugal/lein-flyway.git"}

  :pom-addition [:developers 
                 [:developer
                  [:name "Zhiheng Li"]
                  [:url "https://github.com/metaphor"]
                  [:email "zhiheng.li.metaphor@gmail.com"]
                  [:timezone "+8"]]
                 [:developer
                  [:name "Rugal Bernstein"]
                  [:url "https://github.com/Rugal"]
                  [:email "this@rug.al"]
                  [:timezone "+8"]]]

  :eval-in-leiningen true

  :source-paths ["src" "src/main/clojure"]
  :java-source-paths ["src/main/java"]  ; Java source is stored separately.
  :test-paths ["src/test/clojure"]
  :resource-paths ["src/main/resources"] ; Non-code files included in classpath/jar.

  :dependencies [[org.flywaydb/flyway-core "9.22.3"]]

  :plugins      [[lein-environ "1.2.0"]
                 [lein-pprint "1.3.2"]
                 [lein-release "1.0.0"]
                 [lein-bikeshed "0.5.2"]]

  :profiles {:dev {:dependencies [[org.clojure/clojure "1.11.1"]
                                  [com.h2database/h2 "2.2.224"]]
                   :plugins [[com.jakemccrary/lein-test-refresh "0.25.0"]]}
             :uberjar     {:aot :all}
             :production  {}}

  :test-refresh {:changes-only false
                 :quiet false}

  :bikeshed {:var-redefs           false
             :trailing-blank-lines false
             :max-line-length      100
             :name-collisions      false})
