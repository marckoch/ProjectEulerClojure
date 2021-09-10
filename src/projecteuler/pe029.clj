(ns projecteuler.pe029)

(->> (for [a (range 2 101)
           b (range 2 101)]
       (.pow (BigInteger. (str a)) b))
     (into #{})
     count)