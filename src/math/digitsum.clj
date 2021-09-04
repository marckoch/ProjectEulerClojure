(ns math.digitsum)

(defn digitsum
  "Sum of all digits of n."
  [n]
  (->>
   (str n)
   (map #(Character/digit % 10))
   (reduce +)))

(digitsum 1113)