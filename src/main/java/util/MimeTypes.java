package util;


import com.linkapital.core.util.file_analizer.FileAnalizerFactory;

import javax.validation.constraints.NotEmpty;
import java.io.File;
import java.util.HashMap;

import static com.linkapital.core.util.file_analizer.FileAnalizer.FILE;
import static java.util.Locale.ROOT;

public class MimeTypes {

    private static final String MIME_APPLICATION_ANDREW_INSET = "application/andrew-inset";
    private static final String MIME_APPLICATION_JSON = "application/json";
    private static final String MIME_APPLICATION_ZIP = "application/zip";
    private static final String MIME_APPLICATION_X_GZIP = "application/x-gzip";
    private static final String MIME_APPLICATION_TGZ = "application/tgz";
    private static final String MIME_APPLICATION_MSWORD = "application/msword";
    private static final String MIME_APPLICATION_POSTSCRIPT = "application/postscript";
    private static final String MIME_APPLICATION_PDF = "application/pdf";
    private static final String MIME_APPLICATION_JNLP = "application/jnlp";
    private static final String MIME_APPLICATION_MAC_BINHEX40 = "application/mac-binhex40";
    private static final String MIME_APPLICATION_MAC_COMPACTPRO = "application/mac-compactpro";
    private static final String MIME_APPLICATION_MATHML_XML = "application/mathml+xml";
    private static final String MIME_APPLICATION_OCTET_STREAM = "application/octet-stream";
    private static final String MIME_APPLICATION_ODA = "application/oda";
    private static final String MIME_APPLICATION_RDF_XML = "application/rdf+xml";
    private static final String MIME_APPLICATION_JAVA_ARCHIVE = "application/java-archive";
    private static final String MIME_APPLICATION_RDF_SMIL = "application/smil";
    private static final String MIME_APPLICATION_SRGS = "application/srgs";
    private static final String MIME_APPLICATION_SRGS_XML = "application/srgs+xml";
    private static final String MIME_APPLICATION_VND_MIF = "application/vnd.mif";
    private static final String MIME_APPLICATION_VND_MSEXCEL = "application/vnd.ms-excel";
    private static final String MIME_APPLICATION_VND_MSPOWERPOINT = "application/vnd.ms-powerpoint";
    private static final String MIME_APPLICATION_VND_RNREALMEDIA = "application/vnd.rn-realmedia";
    private static final String MIME_APPLICATION_X_BCPIO = "application/x-bcpio";
    private static final String MIME_APPLICATION_X_CDLINK = "application/x-cdlink";
    private static final String MIME_APPLICATION_X_CHESS_PGN = "application/x-chess-pgn";
    private static final String MIME_APPLICATION_X_CPIO = "application/x-cpio";
    private static final String MIME_APPLICATION_X_CSH = "application/x-csh";
    private static final String MIME_APPLICATION_X_DIRECTOR = "application/x-director";
    private static final String MIME_APPLICATION_X_DVI = "application/x-dvi";
    private static final String MIME_APPLICATION_X_FUTURESPLASH = "application/x-futuresplash";
    private static final String MIME_APPLICATION_X_GTAR = "application/x-gtar";
    private static final String MIME_APPLICATION_X_HDF = "application/x-hdf";
    private static final String MIME_APPLICATION_X_JAVASCRIPT = "application/x-javascript";
    private static final String MIME_APPLICATION_X_KOAN = "application/x-koan";
    private static final String MIME_APPLICATION_X_LATEX = "application/x-latex";
    private static final String MIME_APPLICATION_X_NETCDF = "application/x-netcdf";
    private static final String MIME_APPLICATION_X_OGG = "application/x-ogg";
    private static final String MIME_APPLICATION_X_SH = "application/x-sh";
    private static final String MIME_APPLICATION_X_SHAR = "application/x-shar";
    private static final String MIME_APPLICATION_X_SHOCKWAVE_FLASH = "application/x-shockwave-flash";
    private static final String MIME_APPLICATION_X_STUFFIT = "application/x-stuffit";
    private static final String MIME_APPLICATION_X_SV4CPIO = "application/x-sv4cpio";
    private static final String MIME_APPLICATION_X_SV4CRC = "application/x-sv4crc";
    private static final String MIME_APPLICATION_X_TAR = "application/x-tar";
    private static final String MIME_APPLICATION_X_RAR_COMPRESSED = "application/x-rar-compressed";
    private static final String MIME_APPLICATION_X_TCL = "application/x-tcl";
    private static final String MIME_APPLICATION_X_TEX = "application/x-tex";
    private static final String MIME_APPLICATION_X_TEXINFO = "application/x-texinfo";
    private static final String MIME_APPLICATION_X_TROFF = "application/x-troff";
    private static final String MIME_APPLICATION_X_TROFF_MAN = "application/x-troff-man";
    private static final String MIME_APPLICATION_X_TROFF_ME = "application/x-troff-me";
    private static final String MIME_APPLICATION_X_TROFF_MS = "application/x-troff-ms";
    private static final String MIME_APPLICATION_X_USTAR = "application/x-ustar";
    private static final String MIME_APPLICATION_X_WAIS_SOURCE = "application/x-wais-source";
    private static final String MIME_APPLICATION_VND_MOZZILLA_XUL_XML = "application/vnd.mozilla.xul+xml";
    private static final String MIME_APPLICATION_XHTML_XML = "application/xhtml+xml";
    private static final String MIME_APPLICATION_XSLT_XML = "application/xslt+xml";
    private static final String MIME_APPLICATION_XML = "application/xml";
    private static final String MIME_APPLICATION_XML_DTD = "application/xml-dtd";
    private static final String MIME_IMAGE_BMP = "image/bmp";
    private static final String MIME_IMAGE_CGM = "image/cgm";
    private static final String MIME_IMAGE_GIF = "image/gif";
    private static final String MIME_IMAGE_IEF = "image/ief";
    private static final String MIME_IMAGE_JPEG = "image/jpeg";
    private static final String MIME_IMAGE_TIFF = "image/tiff";
    private static final String MIME_IMAGE_PNG = "image/png";
    private static final String MIME_IMAGE_SVG_XML = "image/svg+xml";
    private static final String MIME_IMAGE_VND_DJVU = "image/vnd.djvu";
    private static final String MIME_IMAGE_WAP_WBMP = "image/vnd.wap.wbmp";
    private static final String MIME_IMAGE_X_CMU_RASTER = "image/x-cmu-raster";
    private static final String MIME_IMAGE_X_ICON = "image/x-icon";
    private static final String MIME_IMAGE_X_PORTABLE_ANYMAP = "image/x-portable-anymap";
    private static final String MIME_IMAGE_X_PORTABLE_BITMAP = "image/x-portable-bitmap";
    private static final String MIME_IMAGE_X_PORTABLE_GRAYMAP = "image/x-portable-graymap";
    private static final String MIME_IMAGE_X_PORTABLE_PIXMAP = "image/x-portable-pixmap";
    private static final String MIME_IMAGE_X_RGB = "image/x-rgb";
    private static final String MIME_AUDIO_BASIC = "audio/basic";
    private static final String MIME_AUDIO_MIDI = "audio/midi";
    private static final String MIME_AUDIO_MPEG = "audio/mpeg";
    private static final String MIME_AUDIO_X_AIFF = "audio/x-aiff";
    private static final String MIME_AUDIO_X_MPEGURL = "audio/x-mpegurl";
    private static final String MIME_AUDIO_X_PN_REALAUDIO = "audio/x-pn-realaudio";
    private static final String MIME_AUDIO_X_WAV = "audio/x-wav";
    private static final String MIME_CHEMICAL_X_PDB = "chemical/x-pdb";
    private static final String MIME_CHEMICAL_X_XYZ = "chemical/x-xyz";
    private static final String MIME_MODEL_IGES = "model/iges";
    private static final String MIME_MODEL_MESH = "model/mesh";
    private static final String MIME_MODEL_VRLM = "model/vrml";
    private static final String MIME_TEXT_PLAIN = "text/plain";
    private static final String MIME_TEXT_RICHTEXT = "text/richtext";
    private static final String MIME_TEXT_RTF = "text/rtf";
    private static final String MIME_TEXT_HTML = "text/html";
    private static final String MIME_TEXT_CALENDAR = "text/calendar";
    private static final String MIME_TEXT_CSS = "text/css";
    private static final String MIME_TEXT_SGML = "text/sgml";
    private static final String MIME_TEXT_TAB_SEPARATED_VALUES = "text/tab-separated-values";
    private static final String MIME_TEXT_VND_WAP_XML = "text/vnd.wap.wml";
    private static final String MIME_TEXT_VND_WAP_WMLSCRIPT = "text/vnd.wap.wmlscript";
    private static final String MIME_TEXT_X_SETEXT = "text/x-setext";
    private static final String MIME_TEXT_X_COMPONENT = "text/x-component";
    private static final String MIME_VIDEO_QUICKTIME = "video/quicktime";
    private static final String MIME_VIDEO_MPEG = "video/mpeg";
    private static final String MIME_VIDEO_VND_MPEGURL = "video/vnd.mpegurl";
    private static final String MIME_VIDEO_X_MSVIDEO = "video/x-msvideo";
    private static final String MIME_VIDEO_X_MS_WMV = "video/x-ms-wmv";
    private static final String MIME_VIDEO_X_SGI_MOVIE = "video/x-sgi-movie";
    private static final String MIME_X_CONFERENCE_X_COOLTALK = "x-conference/x-cooltalk";
    private static final HashMap<String, String> mimeMap = new HashMap<>();

    static {
        mimeMap.put("xul", MIME_APPLICATION_VND_MOZZILLA_XUL_XML);
        mimeMap.put("json", MIME_APPLICATION_JSON);
        mimeMap.put("ice", MIME_X_CONFERENCE_X_COOLTALK);
        mimeMap.put("movie", MIME_VIDEO_X_SGI_MOVIE);
        mimeMap.put("avi", MIME_VIDEO_X_MSVIDEO);
        mimeMap.put("wmv", MIME_VIDEO_X_MS_WMV);
        mimeMap.put("m4u", MIME_VIDEO_VND_MPEGURL);
        mimeMap.put("mxu", MIME_VIDEO_VND_MPEGURL);
        mimeMap.put("htc", MIME_TEXT_X_COMPONENT);
        mimeMap.put("etx", MIME_TEXT_X_SETEXT);
        mimeMap.put("wmls", MIME_TEXT_VND_WAP_WMLSCRIPT);
        mimeMap.put("wml", MIME_TEXT_VND_WAP_XML);
        mimeMap.put("tsv", MIME_TEXT_TAB_SEPARATED_VALUES);
        mimeMap.put("sgm", MIME_TEXT_SGML);
        mimeMap.put("sgml", MIME_TEXT_SGML);
        mimeMap.put("css", MIME_TEXT_CSS);
        mimeMap.put("ifb", MIME_TEXT_CALENDAR);
        mimeMap.put("ics", MIME_TEXT_CALENDAR);
        mimeMap.put("wrl", MIME_MODEL_VRLM);
        mimeMap.put("vrlm", MIME_MODEL_VRLM);
        mimeMap.put("silo", MIME_MODEL_MESH);
        mimeMap.put("mesh", MIME_MODEL_MESH);
        mimeMap.put("msh", MIME_MODEL_MESH);
        mimeMap.put("iges", MIME_MODEL_IGES);
        mimeMap.put("igs", MIME_MODEL_IGES);
        mimeMap.put("rgb", MIME_IMAGE_X_RGB);
        mimeMap.put("ppm", MIME_IMAGE_X_PORTABLE_PIXMAP);
        mimeMap.put("pgm", MIME_IMAGE_X_PORTABLE_GRAYMAP);
        mimeMap.put("pbm", MIME_IMAGE_X_PORTABLE_BITMAP);
        mimeMap.put("pnm", MIME_IMAGE_X_PORTABLE_ANYMAP);
        mimeMap.put("ico", MIME_IMAGE_X_ICON);
        mimeMap.put("ras", MIME_IMAGE_X_CMU_RASTER);
        mimeMap.put("wbmp", MIME_IMAGE_WAP_WBMP);
        mimeMap.put("djv", MIME_IMAGE_VND_DJVU);
        mimeMap.put("djvu", MIME_IMAGE_VND_DJVU);
        mimeMap.put("svg", MIME_IMAGE_SVG_XML);
        mimeMap.put("ief", MIME_IMAGE_IEF);
        mimeMap.put("cgm", MIME_IMAGE_CGM);
        mimeMap.put("bmp", MIME_IMAGE_BMP);
        mimeMap.put("xyz", MIME_CHEMICAL_X_XYZ);
        mimeMap.put("pdb", MIME_CHEMICAL_X_PDB);
        mimeMap.put("ra", MIME_AUDIO_X_PN_REALAUDIO);
        mimeMap.put("ram", MIME_AUDIO_X_PN_REALAUDIO);
        mimeMap.put("m3u", MIME_AUDIO_X_MPEGURL);
        mimeMap.put("aifc", MIME_AUDIO_X_AIFF);
        mimeMap.put("aif", MIME_AUDIO_X_AIFF);
        mimeMap.put("aiff", MIME_AUDIO_X_AIFF);
        mimeMap.put("mp3", MIME_AUDIO_MPEG);
        mimeMap.put("mp2", MIME_AUDIO_MPEG);
        mimeMap.put("mp1", MIME_AUDIO_MPEG);
        mimeMap.put("mpga", MIME_AUDIO_MPEG);
        mimeMap.put("kar", MIME_AUDIO_MIDI);
        mimeMap.put("mid", MIME_AUDIO_MIDI);
        mimeMap.put("midi", MIME_AUDIO_MIDI);
        mimeMap.put("dtd", MIME_APPLICATION_XML_DTD);
        mimeMap.put("xsl", MIME_APPLICATION_XML);
        mimeMap.put("xml", MIME_APPLICATION_XML);
        mimeMap.put("xslt", MIME_APPLICATION_XSLT_XML);
        mimeMap.put("xht", MIME_APPLICATION_XHTML_XML);
        mimeMap.put("xhtml", MIME_APPLICATION_XHTML_XML);
        mimeMap.put("src", MIME_APPLICATION_X_WAIS_SOURCE);
        mimeMap.put("ustar", MIME_APPLICATION_X_USTAR);
        mimeMap.put("ms", MIME_APPLICATION_X_TROFF_MS);
        mimeMap.put("me", MIME_APPLICATION_X_TROFF_ME);
        mimeMap.put("man", MIME_APPLICATION_X_TROFF_MAN);
        mimeMap.put("roff", MIME_APPLICATION_X_TROFF);
        mimeMap.put("tr", MIME_APPLICATION_X_TROFF);
        mimeMap.put("t", MIME_APPLICATION_X_TROFF);
        mimeMap.put("texi", MIME_APPLICATION_X_TEXINFO);
        mimeMap.put("texinfo", MIME_APPLICATION_X_TEXINFO);
        mimeMap.put("tex", MIME_APPLICATION_X_TEX);
        mimeMap.put("tcl", MIME_APPLICATION_X_TCL);
        mimeMap.put("sv4crc", MIME_APPLICATION_X_SV4CRC);
        mimeMap.put("sv4cpio", MIME_APPLICATION_X_SV4CPIO);
        mimeMap.put("sit", MIME_APPLICATION_X_STUFFIT);
        mimeMap.put("swf", MIME_APPLICATION_X_SHOCKWAVE_FLASH);
        mimeMap.put("shar", MIME_APPLICATION_X_SHAR);
        mimeMap.put("sh", MIME_APPLICATION_X_SH);
        mimeMap.put("cdf", MIME_APPLICATION_X_NETCDF);
        mimeMap.put("nc", MIME_APPLICATION_X_NETCDF);
        mimeMap.put("latex", MIME_APPLICATION_X_LATEX);
        mimeMap.put("skm", MIME_APPLICATION_X_KOAN);
        mimeMap.put("skt", MIME_APPLICATION_X_KOAN);
        mimeMap.put("skd", MIME_APPLICATION_X_KOAN);
        mimeMap.put("skp", MIME_APPLICATION_X_KOAN);
        mimeMap.put("js", MIME_APPLICATION_X_JAVASCRIPT);
        mimeMap.put("hdf", MIME_APPLICATION_X_HDF);
        mimeMap.put("gtar", MIME_APPLICATION_X_GTAR);
        mimeMap.put("spl", MIME_APPLICATION_X_FUTURESPLASH);
        mimeMap.put("dvi", MIME_APPLICATION_X_DVI);
        mimeMap.put("dxr", MIME_APPLICATION_X_DIRECTOR);
        mimeMap.put("dir", MIME_APPLICATION_X_DIRECTOR);
        mimeMap.put("dcr", MIME_APPLICATION_X_DIRECTOR);
        mimeMap.put("csh", MIME_APPLICATION_X_CSH);
        mimeMap.put("cpio", MIME_APPLICATION_X_CPIO);
        mimeMap.put("pgn", MIME_APPLICATION_X_CHESS_PGN);
        mimeMap.put("vcd", MIME_APPLICATION_X_CDLINK);
        mimeMap.put("bcpio", MIME_APPLICATION_X_BCPIO);
        mimeMap.put("rm", MIME_APPLICATION_VND_RNREALMEDIA);
        mimeMap.put("ppt", MIME_APPLICATION_VND_MSPOWERPOINT);
        mimeMap.put("mif", MIME_APPLICATION_VND_MIF);
        mimeMap.put("grxml", MIME_APPLICATION_SRGS_XML);
        mimeMap.put("gram", MIME_APPLICATION_SRGS);
        mimeMap.put("smil", MIME_APPLICATION_RDF_SMIL);
        mimeMap.put("smi", MIME_APPLICATION_RDF_SMIL);
        mimeMap.put("rdf", MIME_APPLICATION_RDF_XML);
        mimeMap.put("ogg", MIME_APPLICATION_X_OGG);
        mimeMap.put("oda", MIME_APPLICATION_ODA);
        mimeMap.put("dmg", MIME_APPLICATION_OCTET_STREAM);
        mimeMap.put("lzh", MIME_APPLICATION_OCTET_STREAM);
        mimeMap.put("so", MIME_APPLICATION_OCTET_STREAM);
        mimeMap.put("lha", MIME_APPLICATION_OCTET_STREAM);
        mimeMap.put("dms", MIME_APPLICATION_OCTET_STREAM);
        mimeMap.put("bin", MIME_APPLICATION_OCTET_STREAM);
        mimeMap.put("mathml", MIME_APPLICATION_MATHML_XML);
        mimeMap.put("cpt", MIME_APPLICATION_MAC_COMPACTPRO);
        mimeMap.put("hqx", MIME_APPLICATION_MAC_BINHEX40);
        mimeMap.put("jnlp", MIME_APPLICATION_JNLP);
        mimeMap.put("ez", MIME_APPLICATION_ANDREW_INSET);
        mimeMap.put("txt", MIME_TEXT_PLAIN);
        mimeMap.put("ini", MIME_TEXT_PLAIN);
        mimeMap.put("c", MIME_TEXT_PLAIN);
        mimeMap.put("h", MIME_TEXT_PLAIN);
        mimeMap.put("cpp", MIME_TEXT_PLAIN);
        mimeMap.put("cxx", MIME_TEXT_PLAIN);
        mimeMap.put("cc", MIME_TEXT_PLAIN);
        mimeMap.put("chh", MIME_TEXT_PLAIN);
        mimeMap.put("java", MIME_TEXT_PLAIN);
        mimeMap.put("csv", MIME_TEXT_PLAIN);
        mimeMap.put("bat", MIME_TEXT_PLAIN);
        mimeMap.put("cmd", MIME_TEXT_PLAIN);
        mimeMap.put("asc", MIME_TEXT_PLAIN);
        mimeMap.put("rtf", MIME_TEXT_RTF);
        mimeMap.put("rtx", MIME_TEXT_RICHTEXT);
        mimeMap.put("html", MIME_TEXT_HTML);
        mimeMap.put("htm", MIME_TEXT_HTML);
        mimeMap.put("zip", MIME_APPLICATION_ZIP);
        mimeMap.put("rar", MIME_APPLICATION_X_RAR_COMPRESSED);
        mimeMap.put("gzip", MIME_APPLICATION_X_GZIP);
        mimeMap.put("gz", MIME_APPLICATION_X_GZIP);
        mimeMap.put("tgz", MIME_APPLICATION_TGZ);
        mimeMap.put("tar", MIME_APPLICATION_X_TAR);
        mimeMap.put("gif", MIME_IMAGE_GIF);
        mimeMap.put("jpeg", MIME_IMAGE_JPEG);
        mimeMap.put("jpg", MIME_IMAGE_JPEG);
        mimeMap.put("jpe", MIME_IMAGE_JPEG);
        mimeMap.put("tiff", MIME_IMAGE_TIFF);
        mimeMap.put("tif", MIME_IMAGE_TIFF);
        mimeMap.put("png", MIME_IMAGE_PNG);
        mimeMap.put("au", MIME_AUDIO_BASIC);
        mimeMap.put("snd", MIME_AUDIO_BASIC);
        mimeMap.put("wav", MIME_AUDIO_X_WAV);
        mimeMap.put("mov", MIME_VIDEO_QUICKTIME);
        mimeMap.put("qt", MIME_VIDEO_QUICKTIME);
        mimeMap.put("mpeg", MIME_VIDEO_MPEG);
        mimeMap.put("mpg", MIME_VIDEO_MPEG);
        mimeMap.put("mpe", MIME_VIDEO_MPEG);
        mimeMap.put("abs", MIME_VIDEO_MPEG);
        mimeMap.put("doc", MIME_APPLICATION_MSWORD);
        mimeMap.put("docx", MIME_APPLICATION_MSWORD);
        mimeMap.put("xls", MIME_APPLICATION_VND_MSEXCEL);
        mimeMap.put("xlsx", MIME_APPLICATION_VND_MSEXCEL);
        mimeMap.put("eps", MIME_APPLICATION_POSTSCRIPT);
        mimeMap.put("ai", MIME_APPLICATION_POSTSCRIPT);
        mimeMap.put("ps", MIME_APPLICATION_POSTSCRIPT);
        mimeMap.put("pdf", MIME_APPLICATION_PDF);
        mimeMap.put("exe", MIME_APPLICATION_OCTET_STREAM);
        mimeMap.put("dll", MIME_APPLICATION_OCTET_STREAM);
        mimeMap.put("class", MIME_APPLICATION_OCTET_STREAM);
        mimeMap.put("jar", MIME_APPLICATION_JAVA_ARCHIVE);
    }

    public MimeTypes() {
    }

    /**
     * Registers MIME type for provided extension. Existing extension type will be overriden.
     */
    static void registerMimeType(@NotEmpty String ext, @NotEmpty String mimeType) {
        mimeMap.put(ext, mimeType);
    }

    /**
     * Returns the corresponding MIME type to the given extension.
     * If no MIME type was found it returns 'application/octet-stream' type.
     */
    public static String getMimeType(String ext) {
        var mimeType = lookupMimeType(ext);
        if (mimeType == null)
            mimeType = MIME_APPLICATION_OCTET_STREAM;

        return mimeType;
    }
    //endregion

    //region Simply returns MIME type or <code>null</code> if no type is found.
    private static String lookupMimeType(String ext) {
        return mimeMap.get(ext.toLowerCase(ROOT));
    }

    /**
     * Gets File Mimetype using Apache Tika
     *
     * @param file the file
     * @return the MimeType
     */
    public static String getMimeType(File file) {
        return FileAnalizerFactory.create(FILE).getMimeType(file);
    }

}
