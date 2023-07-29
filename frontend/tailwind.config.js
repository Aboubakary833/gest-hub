/** @type {import('tailwindcss').Config} */
module.exports = {
  content: [
    "./src/**/*.{html,ts}",
    'node_modules/preline/dist/*.js',
],
darkMode: 'class',
  theme: {
    extend: {
      colors: {
        primary: {
          DEFAULT: "#5876bf",
          900: "#3e5386",
          800: "#465e99",
          700: "#4f6aac",
          600: "#5876bf",
          500: "#6984c5",
          400: "#7991cc",
          300: "#8a9fd2",
          200: "#9badd9",
          100: "#acbbdf",
        },
        success: {
          DEFAULT: "#67c994",
          900: "#3e7959",
          800: "#488d68",
          700: "#52a176",
          600: "#5db585",
          500: "#67c994",
          400: "#76ce9f",
          300: "#85d4a9",
          200: "#95d9b4",
          100: "#a4dfbf",
        },
        warning: {
          DEFAULT: "#ffe569",
          900: "#99893f",
          800: "#b3a04a",
          700: "#ccb754",
          600: "#e6ce5f",
          500: "#ffe569",
          400: "#ffe878",
          300: "#ffea87",
          200: "#ffed96",
          100: "#ffefa5",
        },
        danger: {
          DEFAULT: "#ff7070",
          900: "#994343",
          800: "#b34e4e",
          700: "#cc5a5a",
          600: "#e66565",
          500: "#ff7070",
          400: "#ff7e7e",
          300: "#ff8d8d",
          200: "#ff9b9b",
          100: "#ffa9a9",
        },
        black: "#000000",
        white: "#FFFFFF",
      },
    },
  },
  plugins: [
    require('preline/plugin'),
  ],
}

