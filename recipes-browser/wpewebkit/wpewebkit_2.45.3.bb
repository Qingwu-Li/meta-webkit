require wpewebkit.inc
require conf/include/devupstream.inc


SRC_URI = "https://wpewebkit.org/releases/${BPN}-${PV}.tar.xz;name=tarball \
          "

SRC_URI[tarball.sha256sum] = "7c95fb4cfdb514e7369cc9836cff3948728af353a34ad50575322161b7c43b62"

SRC_URI:class-devupstream = "git://github.com/WebKit/WebKit.git;protocol=https;branch=main"
SRCREV:class-devupstream = "b7fdcc092a033f77d299b7c19af25dee1d6196c0"

# Since 2.44+. The ENABLE_ACCESSIBILITY build option has been removed.
# A new USE_ATK option may be used to disable accessibility.
PACKAGECONFIG[accessibility] = "-DUSE_ATK=ON,-DUSE_ATK=OFF,atk at-spi2-atk"
PACKAGECONFIG[libbacktrace] = "-DUSE_LIBBACKTRACE=ON,-DUSE_LIBBACKTRACE=OFF,libbacktrace"
PACKAGECONFIG:append = " libbacktrace"

DEPENDS += " libinput libtasn1"

# The public option DENABLE_WPE_PLATFORM_WAYLAND is set to ON by default.
# It's requires the dependencies wayland-protocols and wayland-native.
DEPENDS:append = ' wayland-protocols wayland-native'
