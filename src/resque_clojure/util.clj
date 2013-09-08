(ns resque-clojure.util)

(defn includes? [coll e]
  (some #{e} coll))

(defn filter-map [map keys]
  "return a new map containing only the key/value pairs that match the keys"
  (into {} (filter (fn [[k v]] (includes? keys k)) map)))

(defn print-exception [e]
  (println "Exception:" e
           "\nTrace:\n"
           (->> (.getStackTrace e)
                (map #(str "\t" %))
                (clojure.string/join "\n"))
           "\n"))
