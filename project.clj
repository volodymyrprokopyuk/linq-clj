(defproject linq-clj "0.1.0-SNAPSHOT"
  :description "101 LINQ Samples"
  :url "https://github.com/volodymyrprokopyuk/linq-clj"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [ [ org.clojure/clojure "1.7.0" ]
                  [ org.clojure/data.zip "0.1.1" ]
                  [ clj-time "0.11.0" ] ]
  :main ^:skip-aot linq-clj.core
  :target-path "target/%s"
  :profiles {:uberjar {:aot :all}})
