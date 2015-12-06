package stats

import scalafx.application.JFXApp
import scalafx.geometry.Insets
import scalafx.scene.Scene
import scalafx.scene.control._
import scalafx.scene.layout.VBox

class StatsApp extends JFXApp {
  val content = new VBox {
    maxWidth = 400
    maxHeight = 400
    spacing = 6
    padding = Insets(6)
    children = List()
  }

  val toolbar = new ToolBar {
    content = List()
  }

  val pane = new VBox {
    maxWidth = 400
    maxHeight = 400
    spacing = 6
    padding = Insets(6)
    children = List(toolbar, content)
  }

  stage = new JFXApp.PrimaryStage {
    title.value = "Stats"
    scene = new Scene {
      root = pane
    }
  }
}