/**
 * Created by Chris on 6/9/2015.
 */
object AwesomeXmlFormatter {
  def formatNodes(nodes: Array[String], rule: String) = {
    //build output
    var output = "<?xml version=\"1.0\" ?>\n<enemy>\n    <behaviour>\n        <root x=\"110\" y=\"40\">\n            <string id=\"Comment\">Map nodes</string>\n            <normal>\n"
    nodes.foreach(x => {
      output += rule.replaceAll("NODENAME", x) + "\n"
    })
    output += "</normal>\n        </root>\n    </behaviour>\n</enemy>"
    //return output
    output
  }
}
