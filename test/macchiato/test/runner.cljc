(ns macchiato.test.runner
  (:require
   #?(:clj [doo.runner :refer-macros [doo-tests]]
      :cljs [clojure.test :refer-macros [run-tests]])
   [macchiato.test.http.request]
   [macchiato.test.http.response]))

(#?(:clj doo-tests
    :cljs run-tests)
 'macchiato.test.http.request
 'macchiato.test.http.response)
