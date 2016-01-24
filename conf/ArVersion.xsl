<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="2.0" xmlns:fo="http://www.w3.org/1999/XSL/Format" xmlns:xsl="http://www.w3.org/1999/XSL/Transform" xmlns:xs="http://www.w3.org/2001/XMLSchema">
	<xsl:output method="xml" version="1.0" indent="yes"/>
<!-- 
****************************************
** Parameter
****************************************
 -->
	<xsl:param name="Seitenbreite">210mm</xsl:param>
	<xsl:param name="Seitenhoehe">297mm</xsl:param>
	<xsl:param name="Rand-Inhalt-rechts">10mm 15mm 18mm 18mm</xsl:param>
	<xsl:param name="Satzspiegel-Inhalt-rechts">15mm 0mm 15mm 0mm</xsl:param>
	<xsl:param name="Rand-Inhalt-links">10mm 15mm 18mm 18mm</xsl:param>
	<xsl:param name="Satzspiegel-Inhalt-links">15mm 0mm 15mm 0mm</xsl:param>

	<!-- xsl:param name="Satzspiegel-Inhalt-rechts">20mm 30mm 15mm 0mm</xsl:param>
	<xsl:param name="Rand-Inhalt-links">10mm 18mm 18mm 7mm</xsl:param>
	<xsl:param name="Satzspiegel-Inhalt-links">20mm 0mm 15mm 30mm</xsl:param -->

<!-- 
****************************************
** Attribute-sets
****************************************
 -->
	<xsl:attribute-set name="Ueberschrift-Titel1">
		<xsl:attribute name="font-family">Helvetica</xsl:attribute>
		<xsl:attribute name="font-size">20pt</xsl:attribute>
		<xsl:attribute name="font-weight">bold</xsl:attribute>
		<xsl:attribute name="text-align">left</xsl:attribute>
		<xsl:attribute name="space-before">20pt</xsl:attribute>
		<xsl:attribute name="space-after">10pt</xsl:attribute>
		<xsl:attribute name="keep-with-next.within-page">always</xsl:attribute>
		<xsl:attribute name="hyphenate">false</xsl:attribute>
	</xsl:attribute-set>
	<xsl:attribute-set name="Ueberschrift-Titel2">
		<xsl:attribute name="font-family">Helvetica</xsl:attribute>
		<xsl:attribute name="font-size">16pt</xsl:attribute>
		<xsl:attribute name="font-weight">bold</xsl:attribute>
		<xsl:attribute name="text-align">left</xsl:attribute>
		<xsl:attribute name="space-before">20pt</xsl:attribute>
		<xsl:attribute name="space-after">10pt</xsl:attribute>
		<xsl:attribute name="keep-with-next.within-page">always</xsl:attribute>
		<xsl:attribute name="hyphenate">false</xsl:attribute>
	</xsl:attribute-set>
	<xsl:attribute-set name="Ueberschrift-Titel3">
		<xsl:attribute name="font-family">Helvetica</xsl:attribute>
		<xsl:attribute name="font-size">12pt</xsl:attribute>
		<xsl:attribute name="font-weight">bold</xsl:attribute>
		<xsl:attribute name="text-align">left</xsl:attribute>
		<xsl:attribute name="space-before">12pt</xsl:attribute>
		<xsl:attribute name="space-after">6pt</xsl:attribute>
		<xsl:attribute name="keep-with-next.within-page">always</xsl:attribute>
		<xsl:attribute name="hyphenate">false</xsl:attribute>
	</xsl:attribute-set>
	<xsl:attribute-set name="Ueberschrift-Titel4">
		<xsl:attribute name="font-family">Helvetica</xsl:attribute>
		<xsl:attribute name="font-size">10pt</xsl:attribute>
		<xsl:attribute name="font-weight">bold</xsl:attribute>
		<xsl:attribute name="text-align">left</xsl:attribute>
		<xsl:attribute name="space-before">6pt</xsl:attribute>
		<xsl:attribute name="space-after">3pt</xsl:attribute>
		<xsl:attribute name="keep-with-next.within-page">always</xsl:attribute>
		<xsl:attribute name="hyphenate">false</xsl:attribute>
	</xsl:attribute-set>
	<xsl:attribute-set name="Ueberschrift-Titel5">
		<xsl:attribute name="font-family">Helvetica</xsl:attribute>
		<xsl:attribute name="font-size">10pt</xsl:attribute>
		<xsl:attribute name="font-style">italic</xsl:attribute>
		<xsl:attribute name="font-weight">normal</xsl:attribute>
		<xsl:attribute name="text-align">left</xsl:attribute>
		<xsl:attribute name="space-before">6pt</xsl:attribute>
		<xsl:attribute name="space-after">3pt</xsl:attribute>
		<xsl:attribute name="keep-with-next.within-page">always</xsl:attribute>
		<xsl:attribute name="hyphenate">false</xsl:attribute>
	</xsl:attribute-set>
	<xsl:attribute-set name="Default">
		<xsl:attribute name="font-family">Helvetica</xsl:attribute>
		<xsl:attribute name="font-size">10pt</xsl:attribute>
		<xsl:attribute name="line-height">1.2</xsl:attribute>
		<xsl:attribute name="xml:lang">en</xsl:attribute>
		<xsl:attribute name="hyphenate">true</xsl:attribute>
	</xsl:attribute-set>
	<!-- 
****************************************
** Seitenaufbau
****************************************
 -->
	<xsl:template match="/">
		<fo:root xsl:use-attribute-sets="Default">
			<fo:layout-master-set>
				<fo:simple-page-master margin="{$Rand-Inhalt-rechts}" master-name="Inhalt-Seiten-rechts" page-height="{$Seitenhoehe}" page-width="{$Seitenbreite}">
					<fo:region-body margin="{$Satzspiegel-Inhalt-rechts}"/>
					<fo:region-before region-name="Inhalt-davor-rechts" extent="10mm" display-align="after" border-after-width="1pt"/>
					<fo:region-after region-name="Inhalt-danach-rechts" extent="0mm" display-align="before" border-before-width="1pt"/>
				</fo:simple-page-master>
				<fo:simple-page-master margin="{$Rand-Inhalt-links}" master-name="Inhalt-Seiten-links" page-height="{$Seitenhoehe}" page-width="{$Seitenbreite}">
					<fo:region-body margin="{$Satzspiegel-Inhalt-links}"/>
					<fo:region-before region-name="Inhalt-davor-links" extent="10mm" display-align="after" border-after-width="1pt"/>
					<fo:region-after region-name="Inhalt-danach-links" extent="0mm" display-align="before" border-before-width="1pt"/>
				</fo:simple-page-master>
				<fo:page-sequence-master master-name="Inhalt-Seiten">
					<fo:repeatable-page-master-alternatives>
						<fo:conditional-page-master-reference master-reference="Inhalt-Seiten-rechts" odd-or-even="odd"/>
						<fo:conditional-page-master-reference master-reference="Inhalt-Seiten-links" odd-or-even="even"/>
					</fo:repeatable-page-master-alternatives>
				</fo:page-sequence-master>
			</fo:layout-master-set>
			<fo:page-sequence master-reference="Inhalt-Seiten">
				<fo:static-content flow-name="Inhalt-davor-rechts">
	            	<xsl:call-template name="myheader"></xsl:call-template>
					<fo:block text-align="outside">
						<fo:retrieve-marker retrieve-class-name="ebene2" retrieve-boundary="page-sequence" retrieve-position="first-starting-within-page"/>
					</fo:block>
				</fo:static-content>
				<fo:static-content flow-name="Inhalt-davor-links">
	            	<xsl:call-template name="myheader"></xsl:call-template>
					<fo:block text-align="outside">
						<fo:retrieve-marker retrieve-class-name="ebene2" retrieve-boundary="page-sequence" retrieve-position="first-starting-within-page"/>
					</fo:block>
				</fo:static-content>
				<fo:static-content flow-name="xsl-footnote-separator">
					<fo:block text-align-last="justify" space-before="4mm" space-after="2mm">
						<fo:leader leader-length="40%" rule-thickness="1pt" leader-pattern="rule"/>
					</fo:block>
				</fo:static-content>
				<fo:flow flow-name="xsl-region-body">
					<fo:block>
						<xsl:apply-templates/>
					</fo:block>
					<fo:block id="theEnd">  </fo:block>
				</fo:flow>
			</fo:page-sequence>
		</fo:root>
	</xsl:template>
<!-- 
****************************************
** Header
****************************************
 -->
 	<xsl:template name="myheader">
	 	<fo:table space-after="8pt" space-before="8pt" width="180mm">
 			<fo:table-body>
				<fo:table-row>
					<fo:table-cell border-style="none" padding="1pt 2pt 2pt 2pt" border-width="0" width="70mm">
						<fo:block xsl:use-attribute-sets="Default">
							Architectural Refactoring
						</fo:block>
					</fo:table-cell>
					<fo:table-cell border-style="none" padding="1pt 2pt 2pt 2pt" border-width="0" width="80mm">
						<fo:block xsl:use-attribute-sets="Default">
							<xsl:value-of select="format-dateTime(current-dateTime(), '[M01]/[D01]/[Y0001] at [H01]:[m01]:[s01]')"/>
						</fo:block>
					</fo:table-cell>
					<fo:table-cell border-style="none" padding="1pt 2pt 2pt 2pt" border-width="0" width="30mm">
						<fo:block xsl:use-attribute-sets="Default">
							Page <fo:page-number/><xsl:text> of </xsl:text><fo:page-number-citation ref-id="theEnd"/>
						</fo:block>
					</fo:table-cell>
				</fo:table-row>
				<fo:table-row>
					<fo:table-cell border-style="none" padding="1pt 2pt 2pt 2pt" border-width="0" width="180mm" number-columns-spanned="3">
						<fo:block xsl:use-attribute-sets="Default">
							<xsl:apply-templates select="arversion/uri"></xsl:apply-templates>
						</fo:block>
					</fo:table-cell>
				</fo:table-row>
			</fo:table-body>
		</fo:table>
	</xsl:template>
	
	<!-- 
****************************************
** Absatzelemente
****************************************
 -->
 	<xsl:template match="arversion">
 		<xsl:apply-templates select="name"/>
 		<fo:table space-after="16pt" space-before="8pt" width="180mm">
 		    <fo:table-header>
                <fo:table-row space-after="10px">
                    <fo:table-cell padding="1pt 2pt 2pt 2pt" width="70mm">
                        <fo:block font-size="10pt" font-weight="bold">Created</fo:block>
                    </fo:table-cell>
                    <fo:table-cell padding="1pt 2pt 2pt 2pt" width="70mm">
                        <fo:block font-size="10pt" font-weight="bold">Modified</fo:block>
                    </fo:table-cell>
                    <fo:table-cell padding="1pt 2pt 2pt 2pt" width="40mm">
                        <fo:block font-size="10pt" font-weight="bold">Status</fo:block>
                    </fo:table-cell>
                </fo:table-row>
            </fo:table-header>
 			<fo:table-body>
				<fo:table-row>
					<fo:table-cell border-style="none" padding="1pt 2pt 2pt 2pt" border-width="0">
						<fo:block xsl:use-attribute-sets="Default">
							<xsl:apply-templates select="created"></xsl:apply-templates>
						</fo:block>
					</fo:table-cell>
					<fo:table-cell border-style="none" padding="1pt 2pt 2pt 2pt" border-width="0">
						<fo:block xsl:use-attribute-sets="Default">
							<xsl:apply-templates select="modified"></xsl:apply-templates>
						</fo:block>
					</fo:table-cell>
					<fo:table-cell border-style="none" padding="1pt 2pt 2pt 2pt" border-width="0">
						<fo:block xsl:use-attribute-sets="Default">
							<xsl:apply-templates select="status"></xsl:apply-templates>
						</fo:block>
					</fo:table-cell>
				</fo:table-row>
			</fo:table-body>
		</fo:table>
		<fo:table space-after="8pt" space-before="8pt">
 		    <fo:table-header>
                <fo:table-row space-after="10px">
                    <fo:table-cell padding="1pt 2pt 2pt 2pt">
                        <fo:block font-size="12pt" font-weight="bold">Context (viewpoint, refinement level)</fo:block>
                    </fo:table-cell>
                    <fo:table-cell padding="1pt 2pt 2pt 2pt">
                        <fo:block font-size="12pt" font-weight="bold">Quality attributes (forces)</fo:block>
                    </fo:table-cell>
                </fo:table-row>
            </fo:table-header>
 			<fo:table-body>
				<fo:table-row>
					<fo:table-cell border-style="none" padding="1pt 2pt 2pt 2pt" border-width="0">
						<fo:list-block provisional-distance-between-starts="0.5cm" provisional-label-separation="0.5cm">
							<xsl:apply-templates select="properties[contains(type, 'ContextElementLink')]" />
						</fo:list-block>
					</fo:table-cell>
					<fo:table-cell border-style="none" padding="1pt 2pt 2pt 2pt" border-width="0">
						<fo:list-block provisional-distance-between-starts="0.5cm" provisional-label-separation="0.5cm">
							<xsl:apply-templates select="properties[contains(type, 'QASElementLink')]" />
						</fo:list-block>
					</fo:table-cell>
				</fo:table-row>
			</fo:table-body>
		</fo:table>
		<fo:block xsl:use-attribute-sets="Ueberschrift-Titel3">
			Smells
		</fo:block>
		<fo:list-block provisional-distance-between-starts="0.5cm" provisional-label-separation="0.5cm">
			<xsl:apply-templates select="smells"/>
		</fo:list-block>
		<xsl:apply-templates select="description"/>
		<fo:table space-after="8pt" space-before="8pt">
 		    <fo:table-header>
                <fo:table-row space-after="10px">
                    <fo:table-cell>
                        <fo:block font-size="12pt" font-weight="bold">Architectural decision(s) to be revisited</fo:block>
                    </fo:table-cell>
                    <fo:table-cell>
                        <fo:block font-size="12pt" font-weight="bold">Affected components and connectors (if modelled explicitly)</fo:block>
                    </fo:table-cell>
                </fo:table-row>
            </fo:table-header>
 			<fo:table-body>
				<fo:table-row>
					<fo:table-cell border-style="none" padding="1pt 2pt 2pt 2pt" border-width="0">
						<fo:list-block provisional-distance-between-starts="0.5cm" provisional-label-separation="0.5cm">
							<xsl:apply-templates select="properties[contains(type, 'DecisionElementLink')]" />
						</fo:list-block>
					</fo:table-cell>
					<fo:table-cell border-style="none" padding="1pt 2pt 2pt 2pt" border-width="0">
						<fo:list-block provisional-distance-between-starts="0.5cm" provisional-label-separation="0.5cm">
							<xsl:apply-templates select="properties[contains(type, 'ComponentElementLink')]" />
						</fo:list-block>
					</fo:table-cell>
				</fo:table-row>
			</fo:table-body>
		</fo:table>
		<fo:block xsl:use-attribute-sets="Ueberschrift-Titel3">
			Tasks
		</fo:block>
		<fo:list-block provisional-distance-between-starts="0.5cm" provisional-label-separation="0.5cm">
			<xsl:apply-templates select="tasks"/>
		</fo:list-block>
		<fo:block xsl:use-attribute-sets="Ueberschrift-Titel3">
			References (links):
		</fo:block>
		<fo:list-block provisional-distance-between-starts="0.5cm" provisional-label-separation="0.5cm">
			<xsl:apply-templates select="properties[contains(type, 'ReferenceElementLink')]" />
		</fo:list-block>
	</xsl:template>
	<xsl:template match="description">
		<fo:block xsl:use-attribute-sets="Ueberschrift-Titel3">
			Description
		</fo:block>
		<xsl:apply-templates/>
	</xsl:template>
	<xsl:template match="smells">
		<fo:list-item>
			<fo:list-item-label end-indent="label-end()">
		      <fo:block>&#x2022;</fo:block>
		    </fo:list-item-label>
		    <fo:list-item-body start-indent="body-start()">
		      <fo:block>
				<xsl:apply-templates select="name"/>
		      </fo:block>
		    </fo:list-item-body>
		</fo:list-item>	
	</xsl:template>
	<xsl:template match="tasks">
		<fo:list-item>
			<fo:list-item-label end-indent="label-end()">
		      <fo:block>&#x2022;</fo:block>
		    </fo:list-item-label>
		    <fo:list-item-body start-indent="body-start()">
		      <fo:block>
				<xsl:value-of select="name"/><xsl:text> :: </xsl:text><xsl:apply-templates select="properties/value[contains(../property/name, 'Type')]"/>
		      </fo:block>
		    </fo:list-item-body>
		</fo:list-item>	
	</xsl:template>
	<xsl:template match="value">
		<xsl:apply-templates/>
	</xsl:template>
	<xsl:template match="created">
		<xsl:variable name="timestamp" select="xs:dateTime('1970-01-01T00:00:00') + current() * xs:dayTimeDuration('PT0.001S')" />
		<xsl:value-of select="format-dateTime($timestamp, '[M01]/[D01]/[Y0001] at [H01]:[m01]:[s01]')"/>
	</xsl:template>
	<xsl:template match="modified">
		<xsl:variable name="timestamp" select="xs:dateTime('1970-01-01T00:00:00') + current() * xs:dayTimeDuration('PT0.001S')" />
		<xsl:value-of select="format-dateTime($timestamp, '[M01]/[D01]/[Y0001] at [H01]:[m01]:[s01]')"/>
	</xsl:template>
	<xsl:template match="status">
		<xsl:apply-templates/>
	</xsl:template>
	<xsl:template match="properties">
		<fo:list-item>
			<fo:list-item-label end-indent="label-end()">
		      <fo:block>&#x2022;</fo:block>
		    </fo:list-item-label>
		    <fo:list-item-body start-indent="body-start()">
		      <fo:block>
				<xsl:apply-templates/>
		      </fo:block>
		    </fo:list-item-body>
		</fo:list-item>	
	</xsl:template>
    
    <xsl:template match="id"></xsl:template>
    <xsl:template match="type"></xsl:template>
<!-- 
****************************************
** HTML Tags
****************************************
 -->
	<xsl:template match="p">
		<fo:block xsl:use-attribute-sets="Default" space-after="12pt">
    		<xsl:apply-templates select="*|text()"/>
		</fo:block>
	</xsl:template>
	<xsl:template match="br">
		<fo:block> </fo:block>
	</xsl:template>
	<xsl:template match="h1">
		<fo:block xsl:use-attribute-sets="Ueberschrift-Titel2">
			<xsl:apply-templates/>
		</fo:block>
	</xsl:template>
	<xsl:template match="h2">
		<fo:block xsl:use-attribute-sets="Ueberschrift-Titel3">
			<xsl:apply-templates/>
		</fo:block>
	</xsl:template>
	<xsl:template match="h3">
		<fo:block xsl:use-attribute-sets="Ueberschrift-Titel4">
			<xsl:apply-templates/>
		</fo:block>
	</xsl:template>
	<xsl:template match="h4">
		<fo:block xsl:use-attribute-sets="Ueberschrift-Titel5">
			<xsl:apply-templates/>
		</fo:block>
	</xsl:template>
	<xsl:template match="b">
		<fo:inline font-weight="bold">
	    	<xsl:apply-templates select="*|text()"/>
		</fo:inline>
	</xsl:template>
	<xsl:template match="i">
		<fo:inline font-style="italic">
	    	<xsl:apply-templates select="*|text()"/>
		</fo:inline>
	</xsl:template>
	<xsl:template match="u">
  		<fo:inline text-decoration="underline">
    		<xsl:apply-templates select="*|text()"/>
  		</fo:inline>
	</xsl:template>
	<xsl:template match="pre">
		<fo:block font-family="monospace" white-space-collapse="false" wrap-option="no-wrap">
	    	<xsl:apply-templates select="*|text()"/>
		</fo:block>
	</xsl:template>
<!-- 
****************************************
** Einzeilige Elemente
****************************************
 -->
	<xsl:template match="emphasis">
		<fo:inline>
			<xsl:choose>
				<xsl:when test="@role='bold'">
					<xsl:attribute name="font-weight">bold</xsl:attribute>
				</xsl:when>
				<xsl:when test="@role='underline'">
					<xsl:attribute name="text-decoration">underline</xsl:attribute>
				</xsl:when>
				<xsl:when test="@role='italic'">
					<xsl:attribute name="font-style">italic</xsl:attribute>
				</xsl:when>
			</xsl:choose>
			<xsl:apply-templates/>
		</fo:inline>
	</xsl:template>
	<!-- 
****************************************
** Überschriften
****************************************
 -->
	<xsl:template match="arversion/name">
		<fo:block xsl:use-attribute-sets="Ueberschrift-Titel1">
			<xsl:apply-templates/>
		</fo:block>
	</xsl:template>
	<xsl:template match="name">
		<fo:block xsl:use-attribute-sets="Default">
			<xsl:apply-templates/>
		</fo:block>
	</xsl:template>
	<xsl:template match="article/section/title">
		<fo:block-container keep-with-next.within-page="always">
			<fo:block>
				<fo:marker marker-class-name="ebene2">
					<xsl:number count="article/section" level="any"/>
					<xsl:text> </xsl:text>
					<xsl:value-of select="."/>
				</fo:marker>
			</fo:block>
		</fo:block-container>
		<fo:block xsl:use-attribute-sets="Ueberschrift-Titel2">
			<fo:table width="100%">
				<fo:table-column column-number="1" column-width="10%"/>
				<fo:table-column column-number="2" column-width="90%"/>
				<fo:table-body>
					<fo:table-row>
						<fo:table-cell column-number="1">
							<fo:block>
								<xsl:number count="article/section" level="any"/>
							</fo:block>
						</fo:table-cell>
						<fo:table-cell column-number="2">
							<fo:block>
								<xsl:apply-templates/>
							</fo:block>
						</fo:table-cell>
					</fo:table-row>
				</fo:table-body>
			</fo:table>
		</fo:block>
	</xsl:template>
	<xsl:template match="article/section/section/title">
		<fo:block xsl:use-attribute-sets="Ueberschrift-Titel3">
			<fo:table width="100%">
				<fo:table-column column-number="1" column-width="10%"/>
				<fo:table-column column-number="2" column-width="90%"/>
				<fo:table-body>
					<fo:table-row>
						<fo:table-cell column-number="1">
							<fo:block>
								<xsl:number level="multiple" format="1.1" count="article/section | article/section/section"/>
							</fo:block>
						</fo:table-cell>
						<fo:table-cell column-number="2">
							<fo:block>
								<xsl:apply-templates/>
							</fo:block>
						</fo:table-cell>
					</fo:table-row>
				</fo:table-body>
			</fo:table>
		</fo:block>
	</xsl:template>
	<xsl:template match="article/section/section/section/title">
		<fo:block xsl:use-attribute-sets="Ueberschrift-Titel4">
			<fo:table width="100%">
				<fo:table-column column-number="1" column-width="10%"/>
				<fo:table-column column-number="2" column-width="90%"/>
				<fo:table-body>
					<fo:table-row>
						<fo:table-cell column-number="1">
							<fo:block>
								<xsl:number level="multiple" format="1.1" count="article/section | article/section/section | article/section/section/section"/>
							</fo:block>
						</fo:table-cell>
						<fo:table-cell column-number="2">
							<fo:block>
								<xsl:apply-templates/>
							</fo:block>
						</fo:table-cell>
					</fo:table-row>
				</fo:table-body>
			</fo:table>
		</fo:block>
	</xsl:template>
	
	<!-- xsl:template match="hr">
	  <fo:block>
	    <fo:leader leader-pattern="rule"/>
	  </fo:block>
	</xsl:template -->
	
	<xsl:template match="hr">
		<fo:block border-bottom-width="0.5pt" border-bottom-style="solid" border-bottom-color="gray" margin-top="10pt" margin-bottom="10pt"></fo:block>
	</xsl:template>                
	
	<!-- 
****************************************
** Fussnoten
****************************************
 -->
	<xsl:template match="footnote">
		<fo:footnote>
			<fo:inline baseline-shift="30%" font-size="70%">
				<xsl:number/>
			</fo:inline>
			<fo:footnote-body start-indent="0mm" end-indent="0mm" text-indent="0mm">
				<fo:list-block provisional-distance-between-starts="3mm">
					<fo:list-item>
						<fo:list-item-label end-indent="label-end()">
							<fo:block>
								<xsl:number/>
							</fo:block>
						</fo:list-item-label>
						<fo:list-item-body start-indent="body-start()">
							<fo:block>
								<xsl:apply-templates select="para"/>
							</fo:block>
						</fo:list-item-body>
					</fo:list-item>
				</fo:list-block>
			</fo:footnote-body>
		</fo:footnote>
	</xsl:template>
	<!-- 
****************************************
** Listen
****************************************
 -->
	<!-- xsl:template match="ol | ul">
		<fo:list-block text-indent="0mm" provisional-distance-between-starts="6mm" space-before="2mm" space-after="2mm">
			<xsl:apply-templates/>
		</fo:list-block>
	</xsl:template>
	<xsl:template match="li">
		<xsl:if test="ancestor::ol">
			<fo:list-item>
				<fo:list-item-label end-indent="label-end()">
					<fo:block>
						<xsl:number/>.
					</fo:block>
				</fo:list-item-label>
				<fo:list-item-body start-indent="body-start()">
					<fo:block>
						<xsl:apply-templates/>
					</fo:block>
				</fo:list-item-body>
			</fo:list-item>
		</xsl:if>
		<xsl:if test="ancestor::ul">
			<fo:list-item>
				<fo:list-item-label end-indent="label-end()">
					<fo:block>
						<fo:block>&#x2022;</fo:block>
					</fo:block>
				</fo:list-item-label>
				<fo:list-item-body start-indent="body-start()">
					<fo:block>
						<xsl:apply-templates/>
					</fo:block>
				</fo:list-item-body>
			</fo:list-item>
		</xsl:if>
	</xsl:template -->
	
<xsl:template match="ol | ul">
  <fo:list-block provisional-distance-between-starts="0.5cm"
    provisional-label-separation="0.5cm">
    <xsl:attribute name="space-after">
      <xsl:choose>
        <xsl:when test="ancestor::ul or ancestor::ol">
          <xsl:text>0pt</xsl:text>
        </xsl:when>
        <xsl:otherwise>
          <xsl:text>12pt</xsl:text>
        </xsl:otherwise>
      </xsl:choose>
    </xsl:attribute>
    <xsl:attribute name="start-indent">
      <xsl:variable name="ancestors">
        <xsl:choose>
          <xsl:when test="count(ancestor::ol) or count(ancestor::ul)">
            <xsl:value-of select="1 + 
                                  (count(ancestor::ol) + 
                                   count(ancestor::ul)) * 
                                  1.25"/>
          </xsl:when>
          <xsl:otherwise>
            <xsl:text>1</xsl:text>
          </xsl:otherwise>
        </xsl:choose>
      </xsl:variable>
      <xsl:value-of select="concat($ancestors, 'cm')"/>
    </xsl:attribute>
    <xsl:apply-templates select="*"/>
  </fo:list-block>
</xsl:template>

<xsl:template match="ul/li">
  <fo:list-item>
    <fo:list-item-label end-indent="label-end()">
      <fo:block>&#x2022;</fo:block>
    </fo:list-item-label>
    <fo:list-item-body start-indent="body-start()">
      <fo:block>
        <xsl:apply-templates select="*|text()"/>
      </fo:block>
    </fo:list-item-body>
  </fo:list-item>
</xsl:template>

<xsl:template match="ol/li">
  <fo:list-item>
    <fo:list-item-label end-indent="label-end()">
      <fo:block>
        <xsl:variable name="value-attr">
          <xsl:choose>
            <xsl:when test="../@start">
              <xsl:number value="position() + ../@start - 1"/>
            </xsl:when>
            <xsl:otherwise>
              <xsl:number value="position()"/>
            </xsl:otherwise>
          </xsl:choose>
        </xsl:variable>
        <xsl:choose>
          <xsl:when test="../@type='i'">
            <xsl:number value="$value-attr" format="i. "/>
          </xsl:when>
          <xsl:when test="../@type='I'">
            <xsl:number value="$value-attr" format="I. "/>
          </xsl:when>
          <xsl:when test="../@type='a'">
            <xsl:number value="$value-attr" format="a. "/>
          </xsl:when>
          <xsl:when test="../@type='A'">
            <xsl:number value="$value-attr" format="A. "/>
          </xsl:when>
          <xsl:otherwise>
            <xsl:number value="$value-attr" format="1. "/>
          </xsl:otherwise>
        </xsl:choose>
      </fo:block>
    </fo:list-item-label>
    <fo:list-item-body start-indent="body-start()">
      <fo:block>
        <xsl:apply-templates select="*|text()"/>
      </fo:block>
    </fo:list-item-body>
  </fo:list-item>
</xsl:template>
	<!-- 
****************************************
** Tabellen
****************************************
 -->
	<xsl:template match="table">
		<fo:table space-after="8pt" space-before="8pt">
			<xsl:apply-templates/>
		</fo:table>
	</xsl:template>
	<xsl:template match="thead">
		<fo:table-header>
			<xsl:apply-templates/>
		</fo:table-header>
	</xsl:template>
	<xsl:template match="tfoot">
		<fo:table-footer background-color="grey">
			<xsl:apply-templates/>
		</fo:table-footer>
	</xsl:template>
	<xsl:template match="tbody">
		<fo:table-body>
			<xsl:apply-templates/>
		</fo:table-body>
	</xsl:template>
	<xsl:template match="tr">
		<fo:table-row>
			<xsl:apply-templates/>
		</fo:table-row>
	</xsl:template>
	<xsl:template match="thead/tr/td">
		<fo:table-cell border-style="solid" padding="1pt 2pt 2pt 2pt" border-width="0.5pt" background-color="grey" font-weight="bold">
			<fo:block>
				<xsl:apply-templates/>
			</fo:block>
		</fo:table-cell>
	</xsl:template>
	<xsl:template match="td">
		<fo:table-cell border-style="solid" border-width="0.5pt" padding="1pt 2pt 2pt 2pt">
			<xsl:attribute name="number-columns-spanned"><xsl:value-of select="@colspan"/></xsl:attribute>
			<xsl:attribute name="number-rows-spanned"><xsl:value-of select="@rowspan"/></xsl:attribute>
			<fo:block>
				<xsl:apply-templates/>
			</fo:block>
		</fo:table-cell>
	</xsl:template>
	<!-- 
****************************************
** Grafiken
****************************************
 -->
	<xsl:template match="imagedata">
		<fo:block>
			<fo:external-graphic src="{@fileref}">
				<xsl:if test="@width">
					<xsl:attribute name="content-width"><xsl:value-of select="@width"/></xsl:attribute>
				</xsl:if>
				<xsl:if test="@height">
					<xsl:attribute name="content-height"><xsl:value-of select="@height"/></xsl:attribute>
				</xsl:if>
			</fo:external-graphic>
		</fo:block>
	</xsl:template>
	
<xsl:template match="img">
  <fo:block space-after="12pt">
    <fo:external-graphic src="{@src}">
      <xsl:if test="@width">
        <xsl:attribute name="content-width">
          <xsl:choose>
            <xsl:when test="contains(@width, 'px')">
              <xsl:value-of select="@width"/>
            </xsl:when>
            <xsl:otherwise>
              <xsl:value-of select="concat(@width, 'px')"/>
            </xsl:otherwise>
          </xsl:choose>
        </xsl:attribute>
      </xsl:if>
      <xsl:if test="@height">
        <xsl:attribute name="content-height">
          <xsl:choose>
            <xsl:when test="contains(@height, 'px')">
              <xsl:value-of select="@height"/>
            </xsl:when>
            <xsl:otherwise>
              <xsl:value-of select="concat(@height, 'px')"/>
            </xsl:otherwise>
          </xsl:choose>
        </xsl:attribute>
      </xsl:if>
      <xsl:if test="@style">
        <xsl:for-each select="tokenize(@style,';')">
	      	<xsl:variable name="vLinksParts" select="tokenize(normalize-space(.),':')" as="xs:string*"/>
	      	<xsl:choose>
	            <xsl:when test="$vLinksParts[1] = 'width'">
	            	<xsl:attribute name="content-width">
		           		<xsl:value-of select="normalize-space($vLinksParts[2])"/>
	        		</xsl:attribute>
	            </xsl:when>
	            <xsl:when test="$vLinksParts[1] = 'height'">
	            	<xsl:attribute name="content-height">
		           		<xsl:value-of select="normalize-space($vLinksParts[2])"/>
	        		</xsl:attribute>
	            </xsl:when>
	            <xsl:otherwise>
	            </xsl:otherwise>
	        </xsl:choose>
        </xsl:for-each>
      </xsl:if>
    </fo:external-graphic>
  </fo:block>
</xsl:template>
<!-- 
****************************************
** Links
****************************************
 -->	
<xsl:template match="a">
  <xsl:choose>
    <xsl:when test="@name">
      <xsl:if test="not(name(following-sibling::*[1]) = 'h1')">
        <fo:block line-height="0" space-after="0pt" 
          font-size="0pt" id="{@name}"/>
      </xsl:if>
    </xsl:when>
    <xsl:when test="@href">
      <fo:basic-link color="blue">
        <xsl:choose>
          <xsl:when test="starts-with(@href, '#')">
            <xsl:attribute name="internal-destination">
              <xsl:value-of select="substring(@href, 2)"/>
            </xsl:attribute>
          </xsl:when>
          <xsl:otherwise>
            <xsl:attribute name="external-destination">
              <xsl:value-of select="@href"/>
            </xsl:attribute>
          </xsl:otherwise>
        </xsl:choose>
        <xsl:apply-templates select="*|text()"/>
      </fo:basic-link>
      <xsl:if test="starts-with(@href, '#')">
        <xsl:text> on page </xsl:text>
        <fo:page-number-citation ref-id="{substring(@href, 2)}"/>
      </xsl:if>
    </xsl:when>
  </xsl:choose>
</xsl:template>
<xsl:template match="link | uri">
  	<xsl:choose>
   		<xsl:when test="text() != 'null'">
	   		<fo:basic-link color="blue">
	     		<xsl:attribute name="external-destination">
	       			<xsl:value-of select="text()"/>
	     		</xsl:attribute>
	     		<xsl:apply-templates select="*|text()"/>
	   		</fo:basic-link>
		</xsl:when>
	</xsl:choose>
</xsl:template>
<!-- 
****************************************
** Abbreviations
****************************************
 -->		
<xsl:template match="abbr">
  <xsl:choose>
    <xsl:when test="@title">
		<xsl:value-of select="text()"/><xsl:text> (</xsl:text><xsl:value-of select="@title"/><xsl:text>)</xsl:text>
    </xsl:when> 
  </xsl:choose>
</xsl:template>
	
<!-- 
****************************************
** Warning unmatched
****************************************
 -->
<xsl:template match="*">
	<xsl:message terminate="no">WARNING: Unmatched element: <xsl:value-of select="name()"/></xsl:message>
	<xsl:apply-templates/>
</xsl:template>

</xsl:stylesheet>
