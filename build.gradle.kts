//プラグインの設定
plugins {
    java
    id("xyz.jpenilla.run-paper") version "3.0.2"
}

repositories {
    mavenCentral()
    maven {
        url = uri("https://repo.papermc.io/repository/maven-public/")
    }
    maven {
        url = uri("https://repo.opencollab.dev/main/")
    }
}

dependencies {
    compileOnly("io.papermc.paper:paper-api:26.1.2.build.+")
}

java {
    toolchain.languageVersion.set(JavaLanguageVersion.of(25))
}

//ここでバージョンの変更

// =========================================================================
// プラグインのバージョン定義 (セマンティック バージョニング: X.Y.Z)
// =========================================================================
// X (Major): 設定の互換性がなくなるレベルの超大型アップデート（大改造）
// Y (Minor): これまでの機能もそのまま使える、新しい機能やコマンドの追加（機能追加）
// Z (Patch): 細かいバグの修正や、メッセージの微調整（不具合修正）
//
// 接尾辞 (-alpha, -beta): 正式リリース前の開発段階を表す
//
// 💡 TurboAngle ネットワークの歴史を例にすると：
// 【1.0.0】最初期：ただのサバイバルモードのサーバーだった頃
// 【2.0.0】大改造：複数のサーバーが集まってできたマルチサーバー（ロビー等）になった頃
// 【3.0.0】大改造：すべてのサーバーを1から全部作り直した頃
// 【3.1.0】機能追加：ドメインが「turboangle.f5.si」から「turboangle.net」に変わった（今！）
//
// ※ 正直、一番右のZ（パッチ）は面倒くさくて今まであんまり変更してない（笑）
// ※ でも、これから複数人で開発したり、ネットに一般公開したりするときは、
//    これがないと「どれがバグ修正済みの最新版か」が分からなくなるから超便利！
// =========================================================================
version = "0.0.0"

// ===== Custom Deploy Configurations =====
val pluginName = project.name

tasks.jar {
    // Removed the build number variable, naming it standard plugin-version.jar
    archiveFileName.set("$pluginName-${project.version}.jar")
}


tasks.register<Copy>("deployPlugin") {
    dependsOn(tasks.jar)

    from(tasks.jar)
}

tasks.build {
    finalizedBy("deployPlugin")
}