inherit qt6-cmake

CMAKE_QT_OECONF = "\
    -DUSE_QT6=ON \
"

# Move the plugin to the default QML directory to ensure
# accessible by QML applications with default settings.
do_install:append() {
    if [ -d ${D}${libdir}/qt6/qml/org/wpewebkit ]; then
        install -d ${D}${libdir}/qml/org/
        mv ${D}${libdir}/qt6/qml/org/wpewebkit ${D}${libdir}/qml/org/
        rm -rf ${D}${libdir}/qt6
    fi
}

FILES:${PN}-qtwpe-qml-plugin += "${libdir}/qml/org/wpewebkit/qtwpe/*"
