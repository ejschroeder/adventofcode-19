(ns day01)  

(require
 '[clojure.string :refer [split-lines]]
 '[clojure.java.io :as io])

(defn get-input [file]
  (->>
   file
   io/resource
   slurp
   split-lines
   (map #(Integer/parseInt %))))

(defn fuel-req [fuel]
  (- (quot fuel 3) 2))

(defn calc-fuel [starting-fuel]
  (loop [fuel (fuel-req starting-fuel) total 0]
     (if (<= fuel 0)
       total
       (recur (fuel-req fuel) (+ total fuel)))))

(defn -main [& args]
  (let [input (get-input "day01/input.txt")]
    (println (->> input
      (map #(- (quot % 3) 2))
      (reduce +)))

    (println (->> input
      (map calc-fuel)
      (reduce +)))))
