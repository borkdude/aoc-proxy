(ns index)

(defn ^:async handler [{:keys [method] :as req} _env _ctx]
  (if (= :GET method)
    (let [params (-> req :url (js/URL.) :searchParams)
          {:keys [aoc-token day year]} params]
      (if (and aoc-token day year)
        (let [resp (js-await (js/fetch (str "https://adventofcode.com/" year "/day/" day "/input")
                                       {:headers {:cookie (str "session=" aoc-token)}}))
              body (js-await (.text resp))
              resp (js/Response. body {:headers {"Access-Control-Allow-Origin" "*"}})]
          resp)
        (js/Response. "Set 'aoc-token, 'day' and 'year' as a URL query parameter" {:status 400
                                                                                   :headers {"Access-Control-Allow-Origin" "*"}})))
    ;; response for :OPTION
    (js/Response. nil {:status 200
                       :headers {"Access-Control-Allow-Origin" "*"
                                 "Access-Control-Allow-Methods" "GET,HEAD,POST,OPTIONS"
                                 "Access-Control-Allow-Headers" "*"}})))

(def default
  {:fetch handler})
