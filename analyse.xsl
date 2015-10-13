<?xml version="1.0" encoding="UTF-8"?>
<fo:root xmlns:fo="http://www.w3.org/1999/XSL/Format"
	font-family="Helvetica" font-size="10pt" line-height="1.2" xml:lang="en"
	hyphenate="true">
	<fo:layout-master-set>
		<fo:simple-page-master page-width="210mm"
			page-height="297mm" master-name="Inhalt-Seiten-rechts" margin="10mm 7mm 18mm 18mm">
			<fo:region-body margin="20mm 30mm 15mm 0mm" />
			<fo:region-before border-after-width="1pt"
				display-align="after" extent="10mm" region-name="Inhalt-davor-rechts" />
			<fo:region-after border-before-width="1pt"
				display-align="before" extent="10mm" region-name="Inhalt-danach-rechts" />
		</fo:simple-page-master>
		<fo:simple-page-master page-width="210mm"
			page-height="297mm" master-name="Inhalt-Seiten-links" margin="10mm 18mm 18mm 7mm">
			<fo:region-body margin="20mm 0mm 15mm 30mm" />
			<fo:region-before border-after-width="1pt"
				display-align="after" extent="10mm" region-name="Inhalt-davor-links" />
			<fo:region-after border-before-width="1pt"
				display-align="before" extent="10mm" region-name="Inhalt-danach-links" />
		</fo:simple-page-master>
		<fo:page-sequence-master master-name="Inhalt-Seiten">
			<fo:repeatable-page-master-alternatives>
				<fo:conditional-page-master-reference
					odd-or-even="odd" master-reference="Inhalt-Seiten-rechts" />
				<fo:conditional-page-master-reference
					odd-or-even="even" master-reference="Inhalt-Seiten-links" />
			</fo:repeatable-page-master-alternatives>
		</fo:page-sequence-master>
	</fo:layout-master-set>
	<fo:page-sequence master-reference="Inhalt-Seiten">
		<fo:static-content flow-name="Inhalt-danach-rechts">
			<fo:block text-align="outside">
				Page
				<fo:page-number />
			</fo:block>
		</fo:static-content>
		<fo:static-content flow-name="Inhalt-davor-rechts">
			<fo:block text-align="outside">
				<fo:retrieve-marker retrieve-position="first-starting-within-page"
					retrieve-boundary="page-sequence" retrieve-class-name="ebene2" />
			</fo:block>
		</fo:static-content>
		<fo:static-content flow-name="Inhalt-danach-links">
			<fo:block text-align="outside">
				Page
				<fo:page-number />
			</fo:block>
		</fo:static-content>
		<fo:static-content flow-name="Inhalt-davor-links">
			<fo:block text-align="outside">
				<fo:retrieve-marker retrieve-position="first-starting-within-page"
					retrieve-boundary="page-sequence" retrieve-class-name="ebene2" />
			</fo:block>
		</fo:static-content>
		<fo:static-content flow-name="xsl-footnote-separator">
			<fo:block space-after="2mm" space-before="4mm"
				text-align-last="justify">
				<fo:leader leader-pattern="rule" rule-thickness="1pt"
					leader-length="40%" />
			</fo:block>
		</fo:static-content>
		<fo:flow flow-name="xsl-region-body">
			<fo:block>
				<fo:block font-family="Helvetica" font-size="24pt"
					font-weight="bold" text-align="left" space-before="20pt"
					space-after="10pt" keep-with-next.within-page="always" hyphenate="false">AR
					1</fo:block>
				<fo:block font-family="Helvetica" font-size="18pt"
					font-weight="bold" text-align="left" space-before="20pt"
					space-after="10pt" keep-with-next.within-page="always" hyphenate="false">
					Architectural Refactoring
				</fo:block>
				<fo:table space-before="8pt" space-after="8pt">
					<fo:table-header>
						<fo:table-row background-color="#eee" space-after="10px">
							<fo:table-cell>
								<fo:block font-weight="bold">Created</fo:block>
							</fo:table-cell>
							<fo:table-cell>
								<fo:block font-weight="bold">Modified</fo:block>
							</fo:table-cell>
							<fo:table-cell>
								<fo:block font-weight="bold">Status</fo:block>
							</fo:table-cell>
						</fo:table-row>
					</fo:table-header>
					<fo:table-body>
						<fo:table-row>
							<fo:table-cell border-width="0" padding="1pt 2pt 2pt 2pt"
								border-style="none">
								<fo:block font-family="Helvetica" font-size="10pt"
									line-height="1.2" xml:lang="en" hyphenate="true">1430996402000
								</fo:block>
							</fo:table-cell>
							<fo:table-cell border-width="0" padding="1pt 2pt 2pt 2pt"
								border-style="none">
								<fo:block font-family="Helvetica" font-size="10pt"
									line-height="1.2" xml:lang="en" hyphenate="true">1444664638000
								</fo:block>
							</fo:table-cell>
							<fo:table-cell border-width="0" padding="1pt 2pt 2pt 2pt"
								border-style="none">
								<fo:block font-family="Helvetica" font-size="10pt"
									line-height="1.2" xml:lang="en" hyphenate="true">published</fo:block>
							</fo:table-cell>
						</fo:table-row>
					</fo:table-body>
				</fo:table>
				<fo:table space-before="8pt" space-after="8pt">
					<fo:table-header>
						<fo:table-row background-color="#eee" space-after="10px">
							<fo:table-cell>
								<fo:block font-weight="bold">Context (viewpoint, refinement
									level, enterprise architecture):</fo:block>
							</fo:table-cell>
							<fo:table-cell>
								<fo:block font-weight="bold">Quality attributes and stories
									(forces):</fo:block>
							</fo:table-cell>
						</fo:table-row>
					</fo:table-header>
					<fo:table-body>
						<fo:table-row>
							<fo:table-cell border-width="0" padding="1pt 2pt 2pt 2pt"
								border-style="none">
								<fo:block font-family="Helvetica" font-size="10pt"
									line-height="1.2" xml:lang="en" hyphenate="true">1430996402000
								</fo:block>
							</fo:table-cell>
							<fo:table-cell border-width="0" padding="1pt 2pt 2pt 2pt"
								border-style="none">
								<fo:block font-family="Helvetica" font-size="10pt"
									line-height="1.2" xml:lang="en" hyphenate="true">1444664638000
								</fo:block>
							</fo:table-cell>
						</fo:table-row>
					</fo:table-body>
				</fo:table>
				<fo:block font-family="Helvetica" font-size="14pt"
					font-weight="bold" text-align="left" space-before="12pt"
					space-after="6pt" keep-with-next.within-page="always" hyphenate="false">
					Description
				</fo:block>
				Architectural Refactoring 1
				<fo:list-block space-after="2mm" space-before="2mm"
					provisional-distance-between-starts="6mm" text-indent="0mm" />
				<fo:list-block space-after="2mm" space-before="2mm"
					provisional-distance-between-starts="6mm" text-indent="0mm">
					<fo:list-item>
						<fo:list-item-label end-indent="label-end()">
							<fo:block>1.
							</fo:block>
						</fo:list-item-label>
						<fo:list-item-body start-indent="body-start()">
							<fo:block>asdfsadf</fo:block>
						</fo:list-item-body>
					</fo:list-item>
					<fo:list-item>
						<fo:list-item-label end-indent="label-end()">
							<fo:block>2.
							</fo:block>
						</fo:list-item-label>
						<fo:list-item-body start-indent="body-start()">
							<fo:block>asdf</fo:block>
						</fo:list-item-body>
					</fo:list-item>
					<fo:list-item>
						<fo:list-item-label end-indent="label-end()">
							<fo:block>3.
							</fo:block>
						</fo:list-item-label>
						<fo:list-item-body start-indent="body-start()">
							<fo:block>asdf</fo:block>
						</fo:list-item-body>
					</fo:list-item>
					<fo:list-item>
						<fo:list-item-label end-indent="label-end()">
							<fo:block>4.
							</fo:block>
						</fo:list-item-label>
						<fo:list-item-body start-indent="body-start()">
							<fo:block>asdf</fo:block>
						</fo:list-item-body>
					</fo:list-item>
				</fo:list-block>
				Christiannullstay
				<fo:block font-family="Helvetica" font-size="12pt"
					font-weight="bold" text-align="left" space-before="6pt"
					space-after="3pt" keep-with-next.within-page="always" hyphenate="false">Admin
				</fo:block>
				<fo:block font-family="Helvetica" font-size="14pt"
					font-weight="bold" text-align="left" space-before="12pt"
					space-after="6pt" keep-with-next.within-page="always" hyphenate="false">
					Description
				</fo:block>
				ART
				Administrator11444664638000HSR14446646380001cbisig@hsr.chBisighttp://www.hsr.chkeyword5,keyword6,keyword71444664638000lm
				<fo:block font-family="Helvetica" font-size="12pt"
					font-weight="bold" text-align="left" space-before="6pt"
					space-after="3pt" keep-with-next.within-page="always" hyphenate="false">Smell11
				</fo:block>
				Question1414
				<fo:block font-family="Helvetica" font-size="14pt"
					font-weight="bold" text-align="left" space-before="12pt"
					space-after="6pt" keep-with-next.within-page="always" hyphenate="false">
					Description
				</fo:block>
				This is Smell111144466463800011
				<fo:block font-family="Helvetica" font-size="12pt"
					font-weight="bold" text-align="left" space-before="6pt"
					space-after="3pt" keep-with-next.within-page="always" hyphenate="false">Dependency
				</fo:block>
				3publishedkeyword5,keyword6,keyword71444664638000lm
				<fo:block font-family="Helvetica" font-size="12pt"
					font-weight="bold" text-align="left" space-before="6pt"
					space-after="3pt" keep-with-next.within-page="always" hyphenate="false">Smell14
				</fo:block>
				Question99
				<fo:block font-family="Helvetica" font-size="14pt"
					font-weight="bold" text-align="left" space-before="12pt"
					space-after="6pt" keep-with-next.within-page="always" hyphenate="false">
					Description
				</fo:block>
				This is Smell141144466463800014
				<fo:block font-family="Helvetica" font-size="12pt"
					font-weight="bold" text-align="left" space-before="6pt"
					space-after="3pt" keep-with-next.within-page="always" hyphenate="false">Performance
				</fo:block>
				1publishedkeyword5,keyword6,keyword71444664638000lm
				<fo:block font-family="Helvetica" font-size="12pt"
					font-weight="bold" text-align="left" space-before="6pt"
					space-after="3pt" keep-with-next.within-page="always" hyphenate="false">Smell4
				</fo:block>
				Question1313Question2626
				<fo:block font-family="Helvetica" font-size="14pt"
					font-weight="bold" text-align="left" space-before="12pt"
					space-after="6pt" keep-with-next.within-page="always" hyphenate="false">
					Description
				</fo:block>
				This is Smell4114446646380004
				<fo:block font-family="Helvetica" font-size="12pt"
					font-weight="bold" text-align="left" space-before="6pt"
					space-after="3pt" keep-with-next.within-page="always" hyphenate="false">Complexity
				</fo:block>
				2published1430996402000
				<fo:block font-family="Helvetica" font-size="14pt"
					font-weight="bold" text-align="left" space-before="12pt"
					space-after="6pt" keep-with-next.within-page="always" hyphenate="false">
					Description
				</fo:block>
				Architectural Refactoring 1
				<fo:list-block space-after="2mm" space-before="2mm"
					provisional-distance-between-starts="6mm" text-indent="0mm" />
				<fo:list-block space-after="2mm" space-before="2mm"
					provisional-distance-between-starts="6mm" text-indent="0mm">
					<fo:list-item>
						<fo:list-item-label end-indent="label-end()">
							<fo:block>1.
							</fo:block>
						</fo:list-item-label>
						<fo:list-item-body start-indent="body-start()">
							<fo:block>asdfsadf</fo:block>
						</fo:list-item-body>
					</fo:list-item>
					<fo:list-item>
						<fo:list-item-label end-indent="label-end()">
							<fo:block>2.
							</fo:block>
						</fo:list-item-label>
						<fo:list-item-body start-indent="body-start()">
							<fo:block>asdf</fo:block>
						</fo:list-item-body>
					</fo:list-item>
					<fo:list-item>
						<fo:list-item-label end-indent="label-end()">
							<fo:block>3.
							</fo:block>
						</fo:list-item-label>
						<fo:list-item-body start-indent="body-start()">
							<fo:block>asdf</fo:block>
						</fo:list-item-body>
					</fo:list-item>
					<fo:list-item>
						<fo:list-item-label end-indent="label-end()">
							<fo:block>4.
							</fo:block>
						</fo:list-item-label>
						<fo:list-item-body start-indent="body-start()">
							<fo:block>asdf</fo:block>
						</fo:list-item-body>
					</fo:list-item>
				</fo:list-block>
				14446646380001444664638000Comment 303Christiannullstay
				<fo:block font-family="Helvetica" font-size="12pt"
					font-weight="bold" text-align="left" space-before="6pt"
					space-after="3pt" keep-with-next.within-page="always" hyphenate="false">Admin
				</fo:block>
				<fo:block font-family="Helvetica" font-size="14pt"
					font-weight="bold" text-align="left" space-before="12pt"
					space-after="6pt" keep-with-next.within-page="always" hyphenate="false">
					Description
				</fo:block>
				ART
				Administrator11444664638000HSR14446646380001cbisig@hsr.chBisighttp://www.hsr.ch14446646380003DISCUSSIONnull1
				<fo:block font-family="Helvetica" font-size="24pt"
					font-weight="bold" text-align="left" space-before="20pt"
					space-after="10pt" keep-with-next.within-page="always" hyphenate="false">AR
					1</fo:block>
				<fo:block font-family="Helvetica" font-size="18pt"
					font-weight="bold" text-align="left" space-before="20pt"
					space-after="10pt" keep-with-next.within-page="always" hyphenate="false">
					Architectural Refactoring
				</fo:block>
				14446646380003Christiannullstay
				<fo:block font-family="Helvetica" font-size="12pt"
					font-weight="bold" text-align="left" space-before="6pt"
					space-after="3pt" keep-with-next.within-page="always" hyphenate="false">Admin
				</fo:block>
				<fo:block font-family="Helvetica" font-size="14pt"
					font-weight="bold" text-align="left" space-before="12pt"
					space-after="6pt" keep-with-next.within-page="always" hyphenate="false">
					Description
				</fo:block>
				ART
				Administrator11444664638000HSR14446646380001cbisig@hsr.chBisighttp://www.hsr.chnull
				<fo:block font-family="Helvetica" font-size="12pt"
					font-weight="bold" text-align="left" space-before="6pt"
					space-after="3pt" keep-with-next.within-page="always" hyphenate="false">Create
					SAD</fo:block>
				1
				<fo:block font-family="Helvetica" font-size="12pt"
					font-weight="bold" text-align="left" space-before="6pt"
					space-after="3pt" keep-with-next.within-page="always" hyphenate="false">Type
				</fo:block>
				81Design Task
				<fo:block font-family="Helvetica" font-size="12pt"
					font-weight="bold" text-align="left" space-before="6pt"
					space-after="3pt" keep-with-next.within-page="always" hyphenate="false">Priority
				</fo:block>
				102high
				<fo:block font-family="Helvetica" font-size="12pt"
					font-weight="bold" text-align="left" space-before="6pt"
					space-after="3pt" keep-with-next.within-page="always" hyphenate="false">Estimated
					Duration</fo:block>
				12320hnull
				<fo:block font-family="Helvetica" font-size="12pt"
					font-weight="bold" text-align="left" space-before="6pt"
					space-after="3pt" keep-with-next.within-page="always" hyphenate="false">Organise
					project status meeting</fo:block>
				2
				<fo:block font-family="Helvetica" font-size="12pt"
					font-weight="bold" text-align="left" space-before="6pt"
					space-after="3pt" keep-with-next.within-page="always" hyphenate="false">Type
				</fo:block>
				84Communication Task
				<fo:block font-family="Helvetica" font-size="12pt"
					font-weight="bold" text-align="left" space-before="6pt"
					space-after="3pt" keep-with-next.within-page="always" hyphenate="false">Priority
				</fo:block>
				105medium
				<fo:block font-family="Helvetica" font-size="12pt"
					font-weight="bold" text-align="left" space-before="6pt"
					space-after="3pt" keep-with-next.within-page="always" hyphenate="false">Estimated
					Duration</fo:block>
				12610hnull
				<fo:block font-family="Helvetica" font-size="12pt"
					font-weight="bold" text-align="left" space-before="6pt"
					space-after="3pt" keep-with-next.within-page="always" hyphenate="false">Implement
					change</fo:block>
				4
				<fo:block font-family="Helvetica" font-size="12pt"
					font-weight="bold" text-align="left" space-before="6pt"
					space-after="3pt" keep-with-next.within-page="always" hyphenate="false">Type
				</fo:block>
				810Development Task
				<fo:block font-family="Helvetica" font-size="12pt"
					font-weight="bold" text-align="left" space-before="6pt"
					space-after="3pt" keep-with-next.within-page="always" hyphenate="false">Priority
				</fo:block>
				1011medium
				<fo:block font-family="Helvetica" font-size="12pt"
					font-weight="bold" text-align="left" space-before="6pt"
					space-after="3pt" keep-with-next.within-page="always" hyphenate="false">Estimated
					Duration</fo:block>
				12121hnull
				<fo:block font-family="Helvetica" font-size="12pt"
					font-weight="bold" text-align="left" space-before="6pt"
					space-after="3pt" keep-with-next.within-page="always" hyphenate="false">Purchase
					3rd party software license</fo:block>
				8
				<fo:block font-family="Helvetica" font-size="12pt"
					font-weight="bold" text-align="left" space-before="6pt"
					space-after="3pt" keep-with-next.within-page="always" hyphenate="false">Type
				</fo:block>
				822Commercial Task
				<fo:block font-family="Helvetica" font-size="12pt"
					font-weight="bold" text-align="left" space-before="6pt"
					space-after="3pt" keep-with-next.within-page="always" hyphenate="false">Priority
				</fo:block>
				1023high
				<fo:block font-family="Helvetica" font-size="12pt"
					font-weight="bold" text-align="left" space-before="6pt"
					space-after="3pt" keep-with-next.within-page="always" hyphenate="false">Estimated
					Duration</fo:block>
				122440hnull
				<fo:block font-family="Helvetica" font-size="12pt"
					font-weight="bold" text-align="left" space-before="6pt"
					space-after="3pt" keep-with-next.within-page="always" hyphenate="false">Software
					Architecture Design sign-off</fo:block>
				10
				<fo:block font-family="Helvetica" font-size="12pt"
					font-weight="bold" text-align="left" space-before="6pt"
					space-after="3pt" keep-with-next.within-page="always" hyphenate="false">Type
				</fo:block>
				828Design Task
				<fo:block font-family="Helvetica" font-size="12pt"
					font-weight="bold" text-align="left" space-before="6pt"
					space-after="3pt" keep-with-next.within-page="always" hyphenate="false">Priority
				</fo:block>
				1029medium
				<fo:block font-family="Helvetica" font-size="12pt"
					font-weight="bold" text-align="left" space-before="6pt"
					space-after="3pt" keep-with-next.within-page="always" hyphenate="false">Estimated
					Duration</fo:block>
				12301h
				<fo:block font-family="Helvetica" font-size="12pt"
					font-weight="bold" text-align="left" space-before="6pt"
					space-after="3pt" keep-with-next.within-page="always" hyphenate="false">Description
				</fo:block>
				931The project leader or the software architect calls a meeting with
				all project stakeholders and responsibles. The meeting is used to
				give the last feedback to the Software architecture Document which
				has been spread beforehand. After that the architecture has to be
				signed off by all stakeholders. Make sure all major issues were
				discussed and resolved before the meeting, so no delay in the sign
				off can occur.null
				<fo:block font-family="Helvetica" font-size="12pt"
					font-weight="bold" text-align="left" space-before="6pt"
					space-after="3pt" keep-with-next.within-page="always" hyphenate="false">Order
					Server Hardware</fo:block>
				11
				<fo:block font-family="Helvetica" font-size="12pt"
					font-weight="bold" text-align="left" space-before="6pt"
					space-after="3pt" keep-with-next.within-page="always" hyphenate="false">Type
				</fo:block>
				832Systemmanagement Task
				<fo:block font-family="Helvetica" font-size="12pt"
					font-weight="bold" text-align="left" space-before="6pt"
					space-after="3pt" keep-with-next.within-page="always" hyphenate="false">Priority
				</fo:block>
				1033low
				<fo:block font-family="Helvetica" font-size="12pt"
					font-weight="bold" text-align="left" space-before="6pt"
					space-after="3pt" keep-with-next.within-page="always" hyphenate="false">Estimated
					Duration</fo:block>
				123419h
				<fo:block font-family="Helvetica" font-size="12pt"
					font-weight="bold" text-align="left" space-before="6pt"
					space-after="3pt" keep-with-next.within-page="always" hyphenate="false">Costs
				</fo:block>
				null13QASElementLink
				<fo:block font-family="Helvetica" font-size="12pt"
					font-weight="bold" text-align="left" space-before="6pt"
					space-after="3pt" keep-with-next.within-page="always" hyphenate="false">Performance
				</fo:block>
				http://en.wikipedia.org/wiki/Computer_performance11QASElementLink
				<fo:block font-family="Helvetica" font-size="12pt"
					font-weight="bold" text-align="left" space-before="6pt"
					space-after="3pt" keep-with-next.within-page="always" hyphenate="false">Scalability
				</fo:block>
				null12QASElementLink
				<fo:block font-family="Helvetica" font-size="12pt"
					font-weight="bold" text-align="left" space-before="6pt"
					space-after="3pt" keep-with-next.within-page="always" hyphenate="false">Data
					integrety</fo:block>
				null17QASElementLink
				<fo:block font-family="Helvetica" font-size="12pt"
					font-weight="bold" text-align="left" space-before="6pt"
					space-after="3pt" keep-with-next.within-page="always" hyphenate="false">Context
					View</fo:block>
				null1ContextElementLink
				<fo:block font-family="Helvetica" font-size="12pt"
					font-weight="bold" text-align="left" space-before="6pt"
					space-after="3pt" keep-with-next.within-page="always" hyphenate="false">Logical
					View</fo:block>
				null5ContextElementLink
				<fo:block font-family="Helvetica" font-size="12pt"
					font-weight="bold" text-align="left" space-before="6pt"
					space-after="3pt" keep-with-next.within-page="always" hyphenate="false">Development
					View</fo:block>
				null7ContextElementLink
				<fo:block font-family="Helvetica" font-size="12pt"
					font-weight="bold" text-align="left" space-before="6pt"
					space-after="3pt" keep-with-next.within-page="always" hyphenate="false">Hardware
					(server)</fo:block>
				null26ComponentElementLink
				<fo:block font-family="Helvetica" font-size="12pt"
					font-weight="bold" text-align="left" space-before="6pt"
					space-after="3pt" keep-with-next.within-page="always" hyphenate="false">Middleware
				</fo:block>
				null29ComponentElementLink
				<fo:block font-family="Helvetica" font-size="12pt"
					font-weight="bold" text-align="left" space-before="6pt"
					space-after="3pt" keep-with-next.within-page="always" hyphenate="false">Approach
					to threading (concurrency management)</fo:block>
				null24DecisionElementLink
				<fo:block font-family="Helvetica" font-size="12pt"
					font-weight="bold" text-align="left" space-before="6pt"
					space-after="3pt" keep-with-next.within-page="always" hyphenate="false">Choice
					of thirdparty vendor</fo:block>
				null22DecisionElementLink
				<fo:block font-family="Helvetica" font-size="12pt"
					font-weight="bold" text-align="left" space-before="6pt"
					space-after="3pt" keep-with-next.within-page="always" hyphenate="false">Choice
					of thirdparty vendor</fo:block>
				null23DecisionElementLink
				<fo:block font-family="Helvetica" font-size="12pt"
					font-weight="bold" text-align="left" space-before="6pt"
					space-after="3pt" keep-with-next.within-page="always" hyphenate="false">High
					parallelisation</fo:block>
				null18DecisionElementLink
				<fo:block font-family="Helvetica" font-size="12pt"
					font-weight="bold" text-align="left" space-before="6pt"
					space-after="3pt" keep-with-next.within-page="always" hyphenate="false">Choice
					of hardware plattform</fo:block>
				null19DecisionElementLink
				<fo:block font-family="Helvetica" font-size="12pt"
					font-weight="bold" text-align="left" space-before="6pt"
					space-after="3pt" keep-with-next.within-page="always" hyphenate="false">Just
					Enough Software Architecture [Fairbanks]</fo:block>
				null39ReferenceElementLink
				<fo:block font-family="Helvetica" font-size="12pt"
					font-weight="bold" text-align="left" space-before="6pt"
					space-after="3pt" keep-with-next.within-page="always" hyphenate="false">Software
					Systems Architecture [Rozanski &amp; Woods]</fo:block>
				null35ReferenceElementLink
				<fo:block font-family="Helvetica" font-size="12pt"
					font-weight="bold" text-align="left" space-before="6pt"
					space-after="3pt" keep-with-next.within-page="always" hyphenate="false">UML
					Distilled [Fowler]</fo:block>
				null37ReferenceElementLinkpublished
			</fo:block>
		</fo:flow>
	</fo:page-sequence>
</fo:root>