# ModTools [![Build Status](https://travis-ci.org/the-obsidian/ModTools.svg?branch=master)](https://travis-ci.org/the-obsidian/ModTools)

Tools to enable moderation of our Minecraft servers

## Dependencies

* none

## Installation

1. Download the [latest release](https://github.com/the-obsidian/ModTools/releases) from GitHub
1. Add it to your `plugins` folder
1. Either run Bukkit/Spigot once to generate `ModTools/config.yml` or create it using the guide below.
1. All done!

## Configuration

ModTools has several options that can be configured in the `config.yml` file:

```yaml
# Prefix for plugin message
prefix: '&8[&7ModTools&8] &7'

# Format for spied private message
spy-format: '&8[&7%from% &8-> &7%to%&8] &7%msg%'

# Commands watched by spy
watched-commands:
  - m
  - msg
  - r
  - reply
  - t
  - tell
  - whisper
```

## Permissions

* `modtools.use` - use modtools
* `modtools.spy` - use message spy
* `modtools.spy.auto` - automatically enable message spy on join

## Commands

* `/spy` - toggles message spy

## Features

* Message spy for listening into private messages

## Upcoming Features

* More mod tools
