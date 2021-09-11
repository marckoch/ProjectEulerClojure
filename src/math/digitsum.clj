(ns math.digitsum)

(defn digitsum
  "Sum of all digits of n."
  [n]
  (->>
   (str n)
   (map #(Character/digit % 10))
   (reduce +)))

(digitsum 1113)

(defn sum-nth-power-of-digits
  "Raise each digit of n to the p-th power and sum it all up.
   (sum-nth-power-of-digits 345 2) = 3^2 + 4^2 + 5^2"
  [n p]
  (->>
   (str n)
   (map #(Character/digit % 10))
   (map #(Math/pow % p))
   (map int)
   (reduce +)))

(sum-nth-power-of-digits 234 3)