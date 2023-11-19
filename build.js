const result = await Bun.build({
  entrypoints: ["./out/index.js"],
  outdir: "./dist",
  sourcemap: "external",
  minify: true
});
