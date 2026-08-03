/** @type {import('tailwindcss').Config} */
module.exports = {
  content: [
    "./src/**/*.{html,ts}",
  ],
  theme: {
    extend: {
      colors: {
        'plasma-bg': '#232629',
        'plasma-panel': 'rgba(49, 54, 59, 0.75)',
        'plasma-text': '#fcfcfc',
        'plasma-accent': '#3daee9',
        'plasma-accent-hover': '#3598cb',
        'plasma-border': '#4d5057',
      },
      borderRadius: {
        'plasma': '8px',
      },
      boxShadow: {
        'plasma': '0 4px 6px rgba(0, 0, 0, 0.3)',
      },
      fontFamily: {
        'sans': ['Inter', 'sans-serif'],
      }
    },
  },
  plugins: [],
}
