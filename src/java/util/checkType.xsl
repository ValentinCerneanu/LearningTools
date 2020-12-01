<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
    xmlns:xs="http://www.w3.org/2001/XMLSchema"
    xmlns:fo="http://www.w3.org/1999/XSL/Format"
    exclude-result-prefixes="xs"
    version="2.0">
    <xsl:template match="type">
        <xsl:if test="type=learning">
            <fo:block background-color="#00b2e6" space-after="10pt">
                <xsl:apply-templates/>
            </fo:block>   
        </xsl:if>
        <xsl:if test="type=teaching">
        </xsl:if>
    </xsl:template>
</xsl:stylesheet>