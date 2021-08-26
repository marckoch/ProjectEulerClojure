(ns projecteuler.pe001)

;; small helper fn to make soution readable
(defn multipleOf? [n] #(zero? (rem % n)))

(->> (range 1 1000)
     (filter #(or ((multipleOf? 3) %)
                  ((multipleOf? 5) %)))
     (reduce +))

;;;;;;;;;;;;;;;;;;
;; some experiments
(comment
  (range 1 10)

  (filter #(= 0 (rem % 3)) (range 1 10))


  (->> (range 1 10)
       (filter #(zero? (rem % 3))))

  (->> (range 1 10)
       (filter #(or (zero? (rem % 3))
                    (zero? (rem % 5)))))
  (reduce + (range 1 10))

  ;; without thread macro
  (reduce +
          (filter #((multipleOf? 3) %)
                  (range 1 10)))

  (reduce +
          (filter #(or ((multipleOf? 3) %) ((multipleOf? 5) %))
                  (range 1 1000))))