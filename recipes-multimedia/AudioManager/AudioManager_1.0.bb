SUMMARY = "Genivi AudioManager"

HOMEPAGE = "https://www.genivi.org/"
SECTION = "multimedia"

LICENSE = "MPLv2"
LIC_FILES_CHKSUM = "file://LICENCE;md5=815ca599c9df247a0c7f619bab123dad"

DEPENDS = "DLT-daemon sqlite3 dbus"

SRC_URI = "git://git.genivi.org/srv/git/AudioManager;protocol=git;tag=3c4baa71a0c3176dad0c2dcdafbf802fd28a7200 \
        "
S = "${WORKDIR}/git"
inherit autotools gettext cmake pkgconfig

EXTRA_OECMAKE += "-DWITH_TESTS=OFF"
OECMAKE_CXX_FLAGS +="-ldl"

FILES_${PN} += "${libdir}/audioManager/command/*.so.* \
                ${libdir}/audioManager/control/*.so.* \
                ${libdir}/audioManager/routing/*.so.* \
"
FILES_${PN}-dev += "${libdir}/audioManager/command/*.so \
                    ${libdir}/audioManager/control/*.so \
                    ${libdir}/audioManager/routing/*.so \
"
FILES_${PN}-dbg += "${libdir}/audioManager/command/.debug/* \
                    ${libdir}/audioManager/control/.debug/* \
                    ${libdir}/audioManager/routing/.debug/* \
"