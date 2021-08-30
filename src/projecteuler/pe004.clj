(ns projecteuler.pe004)

(defn palindrome? [n]
  (= (seq (str n))
     (reverse (str n))))

(def palindromes
  (for [x (range 101 999)
        y (range x 999)
        :let [n (* x y)]
        :when (palindrome? n)]
    n))

palindromes

(reduce max palindromes)

;; experiments
(comment

  (palindrome? 110)

  (palindrome? 121)

  (apply str (reverse (str 121))))
