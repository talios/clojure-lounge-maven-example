(defn gen-hal [props]
  (let [resource-factory (com.theoryinpractise.halbuilder.ResourceFactory.)
          resource (doto (.newResource resource-factory "/foo")
                         (.withLink "/home" "home"))]
    (doseq [prop props]
           (.withProperty resource (name (key prop)) (val prop)))
    (.renderContent resource "application/hal+xml")))
