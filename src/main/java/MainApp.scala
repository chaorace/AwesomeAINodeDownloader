
import java.net.URL

import scala.io.Source
import scala.swing._
import scala.swing.event.ButtonClicked

/**
 * Created by Chris on 6/9/2015.
 */

//Downloads nodelists and saves them in Awesomenauts formatted XML
object MainApp extends SimpleSwingApplication{
  override def top: Frame = new MainFrame{
    contents = new BoxPanel(Orientation.Vertical){
      //GUI
      val mapOptions = new ComboBox[Map](Seq[Map]( //Combobox of possible map selections
        new Map("Ribbit IV", new URL("https://docs.google.com/spreadsheets/d/1ga9T6vYJXUEta_M8aI5fnPSJ13EfZyb4vJaSMF5wQig/export?format=csv&id=1ga9T6vYJXUEta_M8aI5fnPSJ13EfZyb4vJaSMF5wQig&gid=2105017707")),
        new Map("Sorona", new URL("https://docs.google.com/spreadsheets/d/1ga9T6vYJXUEta_M8aI5fnPSJ13EfZyb4vJaSMF5wQig/export?format=csv&id=1ga9T6vYJXUEta_M8aI5fnPSJ13EfZyb4vJaSMF5wQig&gid=1546795163")),
        new Map("Aiguillon", new URL("https://docs.google.com/spreadsheets/d/1ga9T6vYJXUEta_M8aI5fnPSJ13EfZyb4vJaSMF5wQig/export?format=csv&id=1ga9T6vYJXUEta_M8aI5fnPSJ13EfZyb4vJaSMF5wQig&gid=16438000")),
        new Map("AI Station 205", new URL("https://docs.google.com/spreadsheets/d/1ga9T6vYJXUEta_M8aI5fnPSJ13EfZyb4vJaSMF5wQig/export?format=csv&id=1ga9T6vYJXUEta_M8aI5fnPSJ13EfZyb4vJaSMF5wQig&gid=225475495")),
        new Map("AI Station 404", new URL("https://docs.google.com/spreadsheets/d/1ga9T6vYJXUEta_M8aI5fnPSJ13EfZyb4vJaSMF5wQig/export?format=csv&id=1ga9T6vYJXUEta_M8aI5fnPSJ13EfZyb4vJaSMF5wQig&gid=1717902971"))
      ))
      val saveButton = new Button{  //Opens a save dialog when clicked
        text = "Save"
        reactions += {
          //Downloads nodes and saves them to selected file after clicking save
          case ButtonClicked(saveButton) => {
            //Processes url into an array of strings representing each node
            val nodes = Source.fromURL(mapOptions.selection.item.url).mkString
          }
        }
      }
      
      contents += new Label{text = "Pick a map to download"}
      contents += mapOptions
      contents += saveButton
    }

  }
}

class Map(name: String, val url: URL){
  override def toString: String = name
}