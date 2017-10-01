organization := "com.gmaslowski"
name := "f1game-telemetry"

scalaVersion := "2.12.3"

val akkaV = "2.5.4"
val logbackV = "1.2.3"

libraryDependencies ++= Seq(
  // play
  guice,
  ws,

  // akka
  "com.typesafe.akka" %% "akka-actor" % akkaV,
  "com.typesafe.akka" %% "akka-slf4j" % akkaV,

  // logging
  "ch.qos.logback" % "logback-classic" % logbackV
)

enablePlugins(PlayScala)
disablePlugins(PlayLayoutPlugin)
PlayKeys.playMonitoredFiles ++= (sourceDirectories in (Compile, TwirlKeys.compileTemplates)).value