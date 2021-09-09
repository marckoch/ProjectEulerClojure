(ns projecteuler.pe026)

(defn cycle-length
  ([n]
   (cond
     (= n 1) 0
     (even? n) 0
     (zero? (mod n 5)) 0
     :else (cycle-length n 1 0)))
  ([n a count]
   (let [a (mod (* a 10) n)
         count (inc count)]
     (if (= a 1)
       count
       (recur n a count)))))

(def index-starting-with-1
  (fn [idx item] [(inc idx) item]))

(->>
 (range 1 1000)
 (map cycle-length)
 (map-indexed index-starting-with-1)
 (apply max-key second)
 first)