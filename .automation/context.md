# TunnelTrench -- Project Context

## What This Is
Vanilla-style 3x3 mining and digging tools. Adds Hammers (3x3 pickaxe) and Excavators (3x3 shovel) in all vanilla material tiers (Wood, Stone, Copper, Gold, Iron, Diamond, Netherite). Crouch to mine or dig a single block. Fully enchantable. Designed for Vanilla+ and lightly modded packs that want faster gathering without breaking progression.

## Project Structure
Multi-loader: `Common/` + `NeoForge/` + `Fabric/`

## Branch Convention
| Branch | Modloaders        |
|--------|-------------------|
| 26.1   | NeoForge + Fabric |

Single active branch. New mod -- started on 26.1.

## Dependencies
No required dependencies. WhiteNoise is not a dependency -- this mod has no configuration. If configuration is added in the future, WhiteNoise would be included at that time.

### Optional Integration Targets
Wendall911 mods: ActuallyHarvest, BetterDays, ChargedCharms, CreeperFireworks, Homeostatic, HomeostaticSeasons, MagicalPsiRevival, MobChampions, ReadyPlayerFun, SimpleTextOverlay, SurvivalistEssentials, TinkerSurvival

## Distribution
Side: both (clientRequired = true, serverRequired = true) CurseForge + Modrinth

## Release Process
Follow the standard wendall911 release process in `../docs/minecraft/MINECRAFT_DEVELOPMENT_NOTES.md`.
