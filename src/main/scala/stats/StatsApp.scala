package stats

import stats.Stats._

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
    padding = Insets(3)
  }

  val ysLabel = new Label {
    text = "YS Data: " + ys.mkString(", ")
    padding = Insets(3)
  }

  val meanLabel = new Label {
    text = "XS Mean: " + mean(xs)
    padding = Insets(3)
  }

  val medianLabel = new Label {
    text = "XS Median: " + median(xs)
    padding = Insets(3)
  }

  val modeLabel = new Label {
    text = "XS Mode: " + mode(xs)
    padding = Insets(3)
  }

  val data = new VBox {
    spacing = 6
    padding = Insets(6)
    children = List(xsLabel, ysLabel)
  }

  val stats = new VBox {
    spacing = 6
    padding = Insets(6)
    children = List(meanLabel, medianLabel, modeLabel)
  }

  val content = new VBox {
    spacing = 6
    padding = Insets(6)
    children = List(data, stats)
  }

  val toolbar = new ToolBar {
    content = List()
  }

  val pane = new VBox {
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