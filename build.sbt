import ReleaseTransformations._

scalaVersion := "2.10.6"

lazy val commonSettings = Seq(
  organization in ThisBuild := "im.dlg"
)

lazy val root = (project in file("."))
  .settings(commonSettings)
  .settings(
    sbtPlugin := true,
    name := "sbt-dialog-houserules",
    description := "sbt plugin for enforcing sbt house rules in Dialog Team.",
    addSbtPlugin("me.lessis" % "bintray-sbt" % "0.3.0"),
    addSbtPlugin("com.github.gseitz" % "sbt-release" % "1.0.3"),
    addSbtPlugin("com.jsuereth" % "sbt-pgp" % "1.0.0"),
    addSbtPlugin("com.thesamet" % "sbt-protoc" % "0.99.12"),
    addSbtPlugin("org.scalariform" % "sbt-scalariform" % "1.8.2"),
    libraryDependencies += "com.trueaccord.scalapb" %% "compilerplugin" % "0.6.6",
    licenses := Seq("Dialog" -> url("https://dlg.im")),
    publishMavenStyle := false,
    bintrayRepository := "sbt-plugins",
    bintrayOrganization := Some("dialog"),
    releaseProcess := Seq(
      checkSnapshotDependencies,
      inquireVersions,
      setReleaseVersion,
      commitReleaseVersion,
      tagRelease,
      publishArtifacts,
      setNextVersion,
      commitNextVersion,
      pushChanges
    )
  )
