# Http request/response helpers for Macchiato

See the [macchiato framework](https://github.com/macchiato-framework) for more details

[![Clojars Project](https://img.shields.io/clojars/v/macchiato/http.svg)](https://clojars.org/macchiato/http)

This project's goal is to provide the request/response constructors in a standalone library. No middleware is included here, only pure functions.
It is what in its very first iteration what `macchiato.util` in Macchiato Core is.

### Examples

In a ClojureScript REPL, try:

```clojure
cljs.user=> (require '[macchiato.http.request :as request])
nil
cljs.user=> (request/request-url {:scheme       :http
                                  :uri          "/foo/bar"
                                 :headers      {"host" "example.com"}
                                 :query-string "x=y"})
"http://example.com/foo/bar?x=y"
```

While if you are using `lumo` makes sure the dependency is on your classpath, then try:

```shell
lumo -c $(clojure -Sdeps '{macchiato/http {:mvn/version "X.Y.Z"}}' -Spath)
```

```clojure
cljs.user=> (require '[macchiato.http.response :as response])
nil
cljs.user=> (response/ok {:foo "bar"})
{:status 200, :headers {}, :body {:foo "bar"}}
```
