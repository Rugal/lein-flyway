(ns al.rug.hanoi-test
  (:require [clojure.test :as t :refer [deftest testing]]))

(defn ^{:private true} do-hanoi
  "Actuall do hanoi tower recursion"
  [from temp to disk]
  (if (> disk 0)
    (do
      (do-hanoi from to temp (- disk 1))
      (println (format "Disk [%d] : %s -> %s" disk from to))
      (do-hanoi temp from to (- disk 1))
      )
    )
  )

(defn hanoi
  "Entrance of hanoi tower"
  [disk]
  (do-hanoi "A" "B" "C" disk))

(deftest read-configuration
  (testing "Read EDN configuration"
    ; (hanoi 1)
    ; (hanoi 2)
    ; (hanoi 3)
    (hanoi 8)
    ))
