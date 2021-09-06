(ns projecteuler.pe024
  (:require [clojure.string :as str]))

; https://medium.com/@aiswaryamathur/find-the-n-th-permutation-of-an-ordered-string-using-factorial-number-system-9c81e34ab0c8
(defn factoradical
  "Calculate factoradical representation of n"
  ([n] (factoradical n 1 []))
  ([n div coll]
   (let [q (quot n div)
         rem (rem n div)]
     (if (zero? q)
       (cons rem coll)
       (recur q (inc div) (cons rem coll))))))

(defn vec-remove 
  "Remove element at index from the given vector"
  [v index]
  (concat (subvec v 0 index)
          (subvec v (inc index))))

(defn build
  ([seed array] (build (vec seed) array []))
  ([seed array result]
   (if (empty? array)
     result
     (build (vec-remove (vec seed) (first array))
            (rest array)
            (conj result (nth seed (first array)))))))

(str/join (build "0123456789" (factoradical (- 1000000 1))))