package stats

import scalafx.application.JFXApp
import scalafx.geometry.Insets
import scalafx.scene.Scene
import scalafx.scene.control._
import scalafx.scene.layout.VBox

object StatsApp extends JFXApp {
  private val xs = Vector[Double](1.0, 2.0, 3.0, 3.0, 4.0, 4.0, 5.0)
  private val ys = Vector[Double](1.5, 2.5, 3.25, 3.5, 4.25, 4.75, 5.5)

  val xsLabel = new Label {
    text = "XS Data: " + xs.mkString(", ")
  }

  val ysLabel = new Label {
    text = "YS Data: " + ys.mkString(", ")
  }

  val content = new VBox {
    maxWidth = 400
    maxHeight = 400
    spacing = 6
    padding = Insets(6)
    children = List(xsLabel, ysLabel)
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