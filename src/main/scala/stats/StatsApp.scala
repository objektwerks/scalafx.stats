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

  val dataLabel = new Label {
    id = "data-label"
    text = "Data"
    padding = Insets(3)
  }

  val xsLabel = new Label {
    text = "xs: " + xs.mkString(", ")
  }

  val ysLabel = new Label {
    text = "ys: " + ys.mkString(", ")
  }

  val statsLabel = new Label {
    id = "stats-label"
    text = "Stats"
    padding = Insets(3)
  }

  val meanLabel = new Label {
    text = "xs mean: " + mean(xs)
  }

  val medianLabel = new Label {
    text = "xs median: " + median(xs)
  }

  val modeLabel = new Label {
    text = "xs mode: " + mode(xs).mkString(", ")
  }

  val rangeLabel = new Label {
    text = "xs range: " + range(xs)
  }

  val histogramLabel = new Label {
    text = "xs histogram: " + histogram(xs).mkString(", ")
  }

  val varianceLabel = new Label {
    text = "xs variance: " + variance(xs)
  }

  val standardDeviationLabel = new Label {
    text = "xs standard deviation: " + standardDeviation(xs)
  }

  val standardErrorLabel = new Label {
    text = "xs standard error: " + standardError(xs)
  }

  val covarianceLabel = new Label {
    text = "xs, ys covariance: " + covariance(xs, ys)
  }

  val correlationCoefficientLabel = new Label {
    text = "xs, ys correlation coefficient: " + correlationCoefficient(xs, ys)
  }

  val data = new VBox {
    spacing = 3
    padding = Insets(3)
    children = List(dataLabel, xsLabel, ysLabel)
  }

  val stats = new VBox {
    spacing = 3
    padding = Insets(3)
    children = List(statsLabel, meanLabel, medianLabel, modeLabel, rangeLabel, histogramLabel, varianceLabel,
      standardDeviationLabel, standardErrorLabel, covarianceLabel)
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
      stylesheets.add("stats.css")
      root = pane
    }
  }
}