(defproject macchiato/http "0.1.0"
  :description "Http request/response helpers for Macchiato."
  :url "https://github.com/macchiato-framework/macchiato-http"
  :scm {:name "git"
        :url  "https://github.com/macchiato-framework/macchiato-http.git"}
  :license {:name "MIT License"
            :url  "http://opensource.org/licenses/MIT"}
  :clojurescript? true
  :dependencies [[com.cognitect/transit-cljs "0.8.256"]]
  :npm {:dependencies []}
  :plugins [[codox "0.6.4"]]
  :profiles {:test {:dependencies [[org.clojure/clojure "1.9.0" :scope "test"]
                                   [org.clojure/clojurescript "1.10.339" :scope "test"]]
                    :plugins [[lein-doo "0.1.10"]
                              [lein-cljsbuild "1.1.7"]]
                    :cljsbuild
                    {:builds
                     {:test
                      {:source-paths ["src" "test"]
                       :compiler     {:main          macchiato.test.runner
                                      :output-dir    "target"
                                      :output-to     "target/test/http.js"
                                      :target        :nodejs
                                      :optimizations :none
                                      :source-map    true
                                      :pretty-print  true}}}}}
             :self-host {:exclusions [org.clojure/clojure
                                      org.clojure/clojurescript]
                         :tach {:test-runner-ns macchiato.test.runner
                                :source-paths ["src" "test"]
                                :force-non-zero-exit-on-test-failure? true
                                :cache? false
                                :debug? true}
                         :plugins [[lein-tach "1.0.0"]]}}

  :release-tasks [["vcs" "assert-committed"]
                  ["change" "version" "leiningen.release/bump-version" "release"]
                  ["vcs" "commit" "Release %s"]
                  ["vcs" "tag"]
                  ["change" "version" "leiningen.release/bump-version"]
                  ["vcs" "commit"]]

  :aliases
  {"test"
   ["do"
    ["clean"]
    ["with-profile" "test" "doo" "node" "test" "once"]]
   "test-watch"
   ["do"
    ["clean"]
    ["with-profile" "test" "doo" "node" "test"]]
   "test-lumo"
   ["do"
    ["clean"]
    ["with-profile" "self-host" "tach" "lumo" "test"]]
   "bump-version"
   ["change" "version" "leiningen.release/bump-version"]})
