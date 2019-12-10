(defproject adventofcode-19 "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.8.0"]
                 [org.clojure/math.combinatorics "0.1.4"]]
  :profiles {:day1 {:main day01}
             :day2 {:main day02}}
  :aliases {"day1" ["with-profile" "day1" "run"]
            "day2" ["with-profile" "day2" "run"]})
