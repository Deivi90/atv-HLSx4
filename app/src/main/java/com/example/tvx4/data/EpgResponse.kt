package com.example.tvx4.data


import com.google.gson.annotations.SerializedName

data class EpgResponse(
    @SerializedName("channels")
    val channels: List<Channel>
) {
    data class Channel(
        @SerializedName("default")
        val default: Boolean,
        @SerializedName("epg_url")
        val epgUrl: String,
        @SerializedName("group")
        val group: Group,
        @SerializedName("group_id")
        val groupId: String,
        @SerializedName("hd")
        val hd: Boolean,
        @SerializedName("id")
        val id: String,
        @SerializedName("image")
        val image: String,
        @SerializedName("liveref")
        val liveref: String,
        @SerializedName("name")
        val name: String,
        @SerializedName("number")
        val number: String,
        @SerializedName("provider_metadata_id")
        val providerMetadataId: Int,
        @SerializedName("provider_metadata_name")
        val providerMetadataName: String
    ) {
        data class Group(
            @SerializedName("common")
            val common: Common
        ) {
            data class Common(
                @SerializedName("date")
                val date: String,
                @SerializedName("description")
                val description: String,
                @SerializedName("duration")
                val duration: Any,
                @SerializedName("extendedcommon")
                val extendedcommon: Extendedcommon,
                @SerializedName("id")
                val id: String,
                @SerializedName("image_background")
                val imageBackground: String,
                @SerializedName("image_base_horizontal")
                val imageBaseHorizontal: String,
                @SerializedName("image_base_square")
                val imageBaseSquare: String,
                @SerializedName("image_base_vertical")
                val imageBaseVertical: String,
                @SerializedName("image_clean_horizontal")
                val imageCleanHorizontal: String,
                @SerializedName("image_clean_square")
                val imageCleanSquare: String,
                @SerializedName("image_clean_vertical")
                val imageCleanVertical: String,
                @SerializedName("image_external")
                val imageExternal: Any,
                @SerializedName("image_frames")
                val imageFrames: String,
                @SerializedName("image_large")
                val imageLarge: String,
                @SerializedName("image_large_alt")
                val imageLargeAlt: String,
                @SerializedName("image_medium")
                val imageMedium: String,
                @SerializedName("image_medium_alt")
                val imageMediumAlt: String,
                @SerializedName("image_small")
                val imageSmall: String,
                @SerializedName("image_small_alt")
                val imageSmallAlt: String,
                @SerializedName("image_sprites")
                val imageSprites: String,
                @SerializedName("image_still")
                val imageStill: Any,
                @SerializedName("image_trickplay")
                val imageTrickplay: String,
                @SerializedName("large_description")
                val largeDescription: String,
                @SerializedName("media_type")
                val mediaType: String,
                @SerializedName("position")
                val position: Int,
                @SerializedName("ranking")
                val ranking: Ranking,
                @SerializedName("short_description")
                val shortDescription: Any,
                @SerializedName("title")
                val title: String,
                @SerializedName("title_uri")
                val titleUri: String
            ) {
                data class Extendedcommon(
                    @SerializedName("format")
                    val format: Format,
                    @SerializedName("genres")
                    val genres: Genres,
                    @SerializedName("media")
                    val media: Media,
                    @SerializedName("roles")
                    val roles: Roles
                ) {
                    data class Format(
                        @SerializedName("est")
                        val est: String,
                        @SerializedName("id")
                        val id: String,
                        @SerializedName("name")
                        val name: String,
                        @SerializedName("sell_type")
                        val sellType: String,
                        @SerializedName("types")
                        val types: String
                    )

                    data class Genres(
                        @SerializedName("genre")
                        val genre: List<Genre>
                    ) {
                        data class Genre(
                            @SerializedName("desc")
                            val desc: String,
                            @SerializedName("id")
                            val id: String,
                            @SerializedName("name")
                            val name: String
                        )
                    }

                    data class Media(
                        @SerializedName("boxoffice")
                        val boxoffice: String,
                        @SerializedName("channel_number")
                        val channelNumber: String,
                        @SerializedName("countryoforigin")
                        val countryoforigin: Countryoforigin,
                        @SerializedName("description_extended")
                        val descriptionExtended: String,
                        @SerializedName("duration")
                        val duration: Any,
                        @SerializedName("encoder_tecnology")
                        val encoderTecnology: EncoderTecnology,
                        @SerializedName("haspreview")
                        val haspreview: String,
                        @SerializedName("islive")
                        val islive: String,
                        @SerializedName("language")
                        val language: Language,
                        @SerializedName("liveref")
                        val liveref: String,
                        @SerializedName("livetype")
                        val livetype: String,
                        @SerializedName("originaltitle")
                        val originaltitle: String,
                        @SerializedName("profile")
                        val profile: Profile,
                        @SerializedName("proveedor")
                        val proveedor: Proveedor,
                        @SerializedName("publishyear")
                        val publishyear: Any,
                        @SerializedName("rating")
                        val rating: Rating,
                        @SerializedName("recorder_technology")
                        val recorderTechnology: RecorderTechnology,
                        @SerializedName("resource_name")
                        val resourceName: Any,
                        @SerializedName("rights")
                        val rights: Rights,
                        @SerializedName("rollingcreditstime")
                        val rollingcreditstime: String,
                        @SerializedName("rollingcreditstimedb")
                        val rollingcreditstimedb: Any,
                        @SerializedName("timeshift")
                        val timeshift: String
                    ) {
                        data class Countryoforigin(
                            @SerializedName("code")
                            val code: String,
                            @SerializedName("desc")
                            val desc: String
                        )

                        data class EncoderTecnology(
                            @SerializedName("desc")
                            val desc: String,
                            @SerializedName("id")
                            val id: String
                        )

                        data class Language(
                            @SerializedName("dubbed")
                            val dubbed: String,
                            @SerializedName("options")
                            val options: Options,
                            @SerializedName("original")
                            val original: Original,
                            @SerializedName("subbed")
                            val subbed: String
                        ) {
                            data class Options(
                                @SerializedName("count")
                                val count: Int,
                                @SerializedName("option")
                                val option: List<Option>
                            ) {
                                data class Option(
                                    @SerializedName("audio")
                                    val audio: String,
                                    @SerializedName("content_id")
                                    val contentId: String,
                                    @SerializedName("credits_start_time")
                                    val creditsStartTime: String,
                                    @SerializedName("current_content")
                                    val currentContent: String,
                                    @SerializedName("desc")
                                    val desc: String,
                                    @SerializedName("encodes")
                                    val encodes: List<String>,
                                    @SerializedName("fast_play")
                                    val fastPlay: FastPlay,
                                    @SerializedName("group_id")
                                    val groupId: String,
                                    @SerializedName("id")
                                    val id: String,
                                    @SerializedName("intro_finish_time")
                                    val introFinishTime: Any,
                                    @SerializedName("intro_start_time")
                                    val introStartTime: Any,
                                    @SerializedName("label_large")
                                    val labelLarge: String,
                                    @SerializedName("label_short")
                                    val labelShort: String,
                                    @SerializedName("option_id")
                                    val optionId: String,
                                    @SerializedName("option_name")
                                    val optionName: String,
                                    @SerializedName("subtitle")
                                    val subtitle: Any
                                ) {
                                    data class FastPlay(
                                        @SerializedName("dvbc")
                                        val dvbc: String,
                                        @SerializedName("external_app")
                                        val externalApp: String,
                                        @SerializedName("ip_multicast_lms")
                                        val ipMulticastLms: String,
                                        @SerializedName("ip_multicast_udp")
                                        val ipMulticastUdp: String
                                    )
                                }
                            }

                            data class Original(
                                @SerializedName("desc")
                                val desc: String,
                                @SerializedName("id")
                                val id: String
                            )
                        }

                        data class Profile(
                            @SerializedName("audiotype")
                            val audiotype: Any,
                            @SerializedName("hd")
                            val hd: Hd,
                            @SerializedName("screenformat")
                            val screenformat: Any,
                            @SerializedName("videotype")
                            val videotype: Any
                        ) {
                            data class Hd(
                                @SerializedName("enabled")
                                val enabled: String
                            )
                        }

                        data class Proveedor(
                            @SerializedName("codigo")
                            val codigo: String,
                            @SerializedName("id")
                            val id: String,
                            @SerializedName("nombre")
                            val nombre: String
                        )

                        data class Rating(
                            @SerializedName("code")
                            val code: String,
                            @SerializedName("desc")
                            val desc: String,
                            @SerializedName("id")
                            val id: String
                        )

                        data class RecorderTechnology(
                            @SerializedName("desc")
                            val desc: String,
                            @SerializedName("id")
                            val id: String
                        )

                        data class Rights(
                            @SerializedName("end_date")
                            val endDate: String,
                            @SerializedName("start_date")
                            val startDate: String
                        )
                    }

                    data class Roles(
                        @SerializedName("role")
                        val role: List<Role>
                    ) {
                        data class Role(
                            @SerializedName("desc")
                            val desc: String,
                            @SerializedName("id")
                            val id: String,
                            @SerializedName("name")
                            val name: String,
                            @SerializedName("talents")
                            val talents: Talents
                        ) {
                            data class Talents(
                                @SerializedName("talent")
                                val talent: List<Talent>
                            ) {
                                data class Talent(
                                    @SerializedName("fullname")
                                    val fullname: String,
                                    @SerializedName("id")
                                    val id: String,
                                    @SerializedName("name")
                                    val name: String,
                                    @SerializedName("surname")
                                    val surname: String
                                )
                            }
                        }
                    }
                }

                data class Ranking(
                    @SerializedName("average_votes")
                    val averageVotes: Double,
                    @SerializedName("views_count")
                    val viewsCount: Int,
                    @SerializedName("votes_count")
                    val votesCount: Int
                )
            }
        }
    }
}