(ns projecteuler.pe036)

(defn palindrome?
  ([n] (palindrome? n 10))
  ([n base] (let [s (Integer/toString n base)]
              (= (seq s)
                 (reverse s)))))

(->> (range 1 1e6)
     (filter #(and (palindrome? % 2)
                   (palindrome? % 10)))
     (reduce +))