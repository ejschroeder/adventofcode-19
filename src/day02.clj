(ns day02)

(require
 '[clojure.string :refer [split-lines]]
 '[clojure.java.io :as io]
 '[clojure.string :as str]
 '[clojure.math.combinatorics :refer [selections]])

(defn get-input [file]
  (as-> file f
    (io/resource f)
    (slurp f)
    (split-lines f)
    (first f)
    (str/split f #",")
    (mapv #(Integer/parseInt %) f)))

(defn get-operator [op]
  (cond
    (= op 1) +
    (= op 2) *))

(defn evaluate [program]
  (loop [pos 0 program program]
    (if (= (nth program pos) 99) 
      program
      (let [[op datapos1 datapos2 resultpos] (subvec program pos (+ pos 4))
            operator (get-operator op)
            data1 (nth program datapos1)
            data2 (nth program datapos2)
            updated-program (assoc program resultpos (operator data1 data2))]
        (recur (+ pos 4) updated-program)))))

(defn setup-program [program [noun verb]]
  (-> program
      (assoc 1 noun)
      (assoc 2 verb)))

(defn find-noun-verb-inputs [program goal]
  (first (filter #(let [program (setup-program program %)]
                    (= goal (first (evaluate program))))
                 (selections (range 100) 2))))

(defn -main [& args]
  (let [program (get-input "day02/input.txt")]
    (println
     (-> program
         (assoc 1 12)
         (assoc 2 2)
         evaluate
         first))
    (println (find-noun-verb-inputs program 19690720))))