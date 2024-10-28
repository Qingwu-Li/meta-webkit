SUMMARY = "Qt6 WPE simple browser application"
LICENSE = "LGPL-2.1-or-later"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/LGPL-2.1-or-later;md5=2a4f4fd2128ea2f65047ee63fbca9f68"

DEPENDS += "qtbase qtdeclarative qtdeclarative-native"
RDEPENDS:${PN} = "wpewebkit wpewebkit-qtwpe-qml-plugin"

inherit cmake qt6-cmake

SRC_URI = "file://CMakeLists.txt \
           file://main.cpp \
           file://main.qml \
           file://qml.qrc \
"

S = "${WORKDIR}"



do_install() {
      install -d ${D}${bindir}/
      install -m 0755 qt6-browser ${D}${bindir}
}
