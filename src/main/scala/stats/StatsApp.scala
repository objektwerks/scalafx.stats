package stats

import scalafx.application.JFXApp3

object StatsApp extends JFXApp3:
  override def start(): Unit =
    val view = StatsView()
    stage = new JFXApp3.PrimaryStage {
    scene = view.scene
    title = "Stats"
  }

  override def stopApp(): Unit = ???