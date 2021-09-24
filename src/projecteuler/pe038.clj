(ns projecteuler.pe038)

(defn multiples
  ([n] (multiples n n))
  ([start diff] (lazy-seq (cons start (multiples (+ start diff) diff)))))

(defn concat-multiples [n]
  (take 9
        (reduce #(if (> (count (str %1)) 9)
                   (reduced %1)
                   (str %1 %2))
                (multiples n))))

(defn pandigital? [n]
  (if (some #{\0 0} n)
    false
    (let [vals (vals (frequencies n))]
      (= vals (repeat 9 1)))))

(->> (range 9 10000)
     (map #(concat-multiples %))
     (filter #(pandigital? %))
     last
     (reduce str))