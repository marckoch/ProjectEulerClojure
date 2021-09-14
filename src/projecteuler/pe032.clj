(ns projecteuler.pe032)

(defn digits [n]
  (map #(Character/getNumericValue %) (str n)))

(defn pandigital? [a b]
  (and
   (every? #(> % 0) (digits a))
   (every? #(> % 0) (digits b))
   (every? #(> % 0) (digits (* a b)))
   (= 9 (+ (count (digits a))
           (count (digits b))
           (count (digits (* a b)))))
   (= 9 (count (set (concat (digits a) (digits b) (digits (* a b))))))))

(reduce + (distinct (concat
                     (for [a (range 1 10)
                           b (range 1000 10000)
                           :when (pandigital? a b)]
                       (* a b))
                     (for [a (range 10 100)
                           b (range 100 1000)
                           :when (pandigital? a b)]
                       (* a b)))))