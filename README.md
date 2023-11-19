# AOC proxy

A Cloudflare worker to read input for Advent of Code puzzles.

## Develop

- Run `npx squint watch` to watch `src` for `.cljs` files. They are written to
`out` as `.js` files.

- Run `bun --hot src/index.js` to run the development server.

## Deploy

Run `bun build.js` to produce the final output in `dist/index.js`.
To deploy to cloudflare, run `bun wrangler deploy`.

The worker is visible [here](https://aox-proxy.borkdude.workers.dev).
